import { useState } from "react";

export default function RoleModal({setRole}) {
  const [role, setRole] = useState(false);

  const [isAdminLogin, setIsAdminLoign] = useState(false);
  const [form, setForm] = useState({username: "", password: ""});

  const chooseRole = (newRole) => {
    localStorage.setItem("role", newRole);
    setRole(newRole);
  };

  const handleLogin = (e) => {
    e.preventDefault();

    if 
  }

  // Keď už má rolu tak sa modálne okno nezobrazí
  if (role) return null;

  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <h3>Vyber zodpovedajúcu rolu</h3>
        <h4>Hosť - čisto pre potencionálneho zamestnávateľa</h4>
        <h4>Admin - súkromné</h4>
        <div className="buttons">
          <button
            className="btn btn-primary"
            onClick={() => chooseRole("Guest")}
          >
            Hosť
          </button>
          <button
            className="btn btn-danger"
            onClick={() => chooseRole("Admin")}
          >
            Admin
          </button>
        </div>
      </div>
    </div>
  );
}
