const BASE = "https://destinationtracker.onrender.com";

function wait(ms) { return new Promise(r => setTimeout(r, ms)); }

async function fetchJson(url, tries = 8){
    for (let i = 0; i < tries; i++){
        try{
            const res = await fetch(url);
            if(!res.ok) throw new Error(`HTTP ${res.status}`);
            return await res.json();
        } catch(e) {
            if (i === tries - 1) throw e;
            await wait(1000 * 2 ** i);
        }
    }
}

export const api = {
  getDestinations: () => fetchJson(`${BASE}/api/destinations`, 4),
  getCategories:   () => fetchJson(`${BASE}/api/categories`, 4),
};