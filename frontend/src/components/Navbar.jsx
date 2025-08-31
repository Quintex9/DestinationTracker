import { NavLink } from "react-router-dom";

export default function Navbar() {
  return (
    <ul className="nav nav-underline">
      <li className="nav-item">
        <NavLink
          className={"nav-link"}
          to="/"
        >
          Domov
        </NavLink>
      </li>
      <li className="nav-item">
        <NavLink
          className={"nav-link"}
          to="/about"
        >
          O stránke
        </NavLink>
      </li>
      <li className="nav-item">
        <NavLink
          className={"nav-link"}
          to="/contact"
        >
          Kontakt
        </NavLink>
      </li>
    </ul>
  );
}
