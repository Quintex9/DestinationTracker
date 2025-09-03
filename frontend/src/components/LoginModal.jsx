const API_BASE = import.meta.env.VITE_API_BASE;

export default function LoginModal(){
const handleSubmit = async (e) => {
  e.preventDefault();

  try {
    const res = await fetch(`${API_BASE}/api/auth/login`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ username, password }),
    });

    const isValid = await res.json();

    if (isValid) {
      localStorage.setItem("role", "admin");
      onLogin("admin");
    } else {
      setError("Nesprávne meno alebo heslo");
    }
  } catch (err) {
    setError("Chyba servera, skús neskôr");
  }
};
}
