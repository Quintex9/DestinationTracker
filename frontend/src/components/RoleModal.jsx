import { useState } from "react";

export default function RoleModal({ setRole }) {
  const [role, setLocalRole] = useState(null);
  const [isAdminLogin, setIsAdminLogin] = useState(false);
  const [form, setForm] = useState({ username: "", password: "" });

  const chooseRole = (newRole) => {
    localStorage.setItem("role", newRole);
    setRole(newRole);       // ⬅️ toto ide von do App.jsx
    setLocalRole(newRole);  // ⬅️ toto je len lokálny stav modalu
  };

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const res = await fetch(`${import.meta.env.VITE_API_BASE}/api/auth/login`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(form),
      });

      if (!res.ok){
        throw new Error("Chyba servera: " + res.status);
      }

      const isValid = await res.json();

      if(isValid){
        chooseRole("Admin");
      } else{
        alert("Nesprávne prihlasovanie údaje")
      }

    } catch (err) {
      console.error("Chyba pri prihlásení:", err);
      alert("Server momentálne nedostupný");
    }
  };

  if (role) return null;

  return (
    <div className="modal-overlay">
      <div className="modal-content">
        {isAdminLogin ? (
          <>
            <h3>Prihlásenie admina</h3>
            <form onSubmit={handleLogin}>
              <input
                type="text"
                placeholder="Meno"
                value={form.username}
                onChange={(e) => setForm({ ...form, username: e.target.value })}
              />
              <input
                type="password"
                placeholder="Heslo"
                value={form.password}
                onChange={(e) => setForm({ ...form, password: e.target.value })}
              />
              <button type="submit">Prihlásiť</button>
            </form>
            <button onClick={() => setIsAdminLogin(false)}>Späť</button>
          </>
        ) : (
          <>
            <h3>Vyber zodpovedajúcu rolu</h3>
            <button onClick={() => chooseRole("Guest")}>Hosť</button>
            <button onClick={() => setIsAdminLogin(true)}>Admin</button>
          </>
        )}
      </div>
    </div>
  );
}
