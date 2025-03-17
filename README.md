
# Documentação da API de Encurtamento de URLs

## Visão Geral
Esta API permite encurtar URLs longas e redirecionar usuários para as URLs originais quando acessarem os links encurtados. É uma solução simples e eficiente para compartilhar URLs longas de forma mais prática.

## Endpoints

### 1. Encurtar URL
**Endpoint:** `POST /encurta`

**Descrição:** Recebe uma URL completa e retorna uma versão encurtada.

**Corpo da Requisição:**
```json
{
  "url": "https://exemplo.com/url-muito-longa"
}
```

**Resposta de Sucesso:**
```json
{
  "urlEncurtada": "http://localhost:8080/r/abc123"
}
```

**Códigos de Status:**
- `201 Created`: URL encurtada com sucesso

---

### 2. Redirecionar para URL Original
**Endpoint:** `GET /r/{urlEncurtada}`

**Descrição:** Redireciona o usuário para a URL original correspondente ao código encurtado.

**Parâmetros de URL:**
- `urlEncurtada`: Código único gerado para a URL encurtada

**Comportamento:**
- Redireciona automaticamente para a URL original
- Retorna erro `404 Not Found` se o código não existir

## Exemplos de Uso

### Encurtar uma URL (Frontend)
```js
fetch("http://localhost:8080/encurta", {
  method: "POST",
  headers: { "Content-Type": "application/json" },
  body: JSON.stringify({ url: "https://exemplo.com/url-muito-longa" })
})
  .then(response => response.json())
  .then(data => console.log("URL encurtada:", data.urlEncurtada));
```

### Usar URL Encurtada
Para usar a URL encurtada, basta compartilhar o link retornado (ex: `http://localhost:8080/r/abc123`). Quando alguém acessar esse link, será automaticamente redirecionado para a URL original.

## Notas de Implementação
- A API gera códigos aleatórios alfanuméricos entre 5 e 10 caracteres
- As URLs encurtadas são armazenadas em um banco de dados MySQL
- O serviço está configurado para rodar na porta `8080`

## Comandos Git para Atualizar o Repositório
```sh
git add .
git commit -m "Atualizando documentação da API"
git push origin main
