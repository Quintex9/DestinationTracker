import { NavLink } from "react-router-dom";

export default function Navbar({setRole}) {
  return (
    <>
      <ul className="nav nav-underline">
        <li className="nav-item">
          <NavLink className={"nav-link"} to="/">
            Domov
          </NavLink>
        </li>
        <li className="nav-item">
          <NavLink className={"nav-link"} to="/mapa">
            Mapa
          </NavLink>
        </li>
        <li className="nav-item">
          <NavLink className={"nav-link"} to="/contact">
            Kontakt
          </NavLink>
        </li>
        {localStorage.getItem("role")? <button
        className="btn btn-primary"
          onClick={() => {
            localStorage.removeItem("role");
            setRole(null);
            window.location.reload();
          }}
        >
          Odhlásiť
        </button> : null}
      </ul>
    </>
  );
}
