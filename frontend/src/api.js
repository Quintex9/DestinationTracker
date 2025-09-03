const BASE = import.meta.env.VITE_API_BASE;


function wait(ms) {
  return new Promise(r => setTimeout(r, ms));
}

async function fetchJson(url, tries = 4) {
  for (let i = 0; i < tries; i++) {
    try {
      const res = await fetch(url);

      if (!res.ok) {
        throw new Error(`HTTP ${res.status}`);
      }

      return await res.json();
    } catch (e) {
      if (i === tries - 1) throw e;
      await wait(500 * (i + 1)); // retry delay: 0.5s, 1s, 1.5s...
    }
  }
}

export const api = {
  getDestinations: () => fetchJson(`${BASE}/api/destinations`, 4),
  getCategories:   () => fetchJson(`${BASE}/api/categories`, 4),
};
