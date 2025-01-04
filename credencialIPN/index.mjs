import fetch from 'node-fetch';
import { JSDOM } from 'jsdom';

export const handler = async (event) => {
    // Configurar CORS
    const headers = {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': 'Content-Type',
        'Access-Control-Allow-Methods': 'POST, OPTIONS'
    };
    
    // Manejar preflight OPTIONS request
    if (event.httpMethod === 'OPTIONS') {
        return {
            statusCode: 200,
            headers,
            body: ''
        };
    }

    try {
        // Obtener la URL del cuerpo de la solicitud
        const body = JSON.parse(event.body);
        const { url } = body;

        if (!url) {
            return {
                statusCode: 400,
                headers,
                body: JSON.stringify({ error: 'URL es requerida' })
            };
        }

        // Realizar la solicitud HTTP
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`Error: ${response.status}`);
        }

        const html = await response.text();
        const dom = new JSDOM(html);
        const document = dom.window.document;

        // Extraer los datos
        const data = {
            nombre: document.querySelector('.nombre')?.textContent.trim() || 'No encontrado',
            boleta: document.querySelector('.boleta')?.textContent.trim() || 'No encontrado',
            vigencia: document.querySelector('.cred')?.textContent.trim() || 'No encontrado',
            carrera: document.querySelector('.carrera')?.textContent.trim() || 'No encontrado',
            escuela: document.querySelector('.escuela')?.textContent.trim() || 'No encontrado'
        };

        return {
            statusCode: 200,
            headers,
            body: JSON.stringify(data)
        };

    } catch (error) {
        return {
            statusCode: 500,
            headers,
            body: JSON.stringify({ error: error.message })
        };
    }
};