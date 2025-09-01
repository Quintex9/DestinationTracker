import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  base: "/", // dôležité pre správne routovanie
  build: {
    outDir: "dist", // tu Vercel hľadá výsledok buildu
  },
})
