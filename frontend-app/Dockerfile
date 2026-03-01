# --- ETAP 1: Budowanie (Build) ---
FROM node:alpine AS build

WORKDIR /app

# Kopiujemy definicje zależności
COPY package.json package-lock.json ./

# Instalujemy zależności (bez zbędnych logów)
RUN npm ci

# Kopiujemy kod źródłowy aplikacji
COPY . .

# Budujemy aplikację
RUN npm run build

# --- ETAP 2: Serwer Nginx (Serve) ---
FROM nginx:alpine

# Usuwamy domyślną stronę Nginx ("Welcome to nginx")
RUN rm -rf /usr/share/nginx/html/*

# Kopiujemy Nasz config (stworzymy go w kroku 3)
COPY nginx/default.conf /etc/nginx/conf.d/default.conf

# Kopiujemy zbudowaną aplikację z ETAPU 1
# Tu jest klucz: kopiujemy z folderu 'browser'
COPY --from=build /app/dist/frontend-app/browser /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]