// src\components\ListaDeUsuarios\index.js

// src/components/ListaDeUsuarios/index.js

import { useState, useEffect } from "react";
import axios from "axios";
import './styles.css';

function ListaDeUsuarios() {
    const [usuarios, setUsuarios] = useState([]);

    useEffect(() => {
        const carregarUsuarios = async () => {
            try {
                const response = await axios.get('http://localhost:8080/cardapio');
                setUsuarios(response.data);
            } catch (error) {
                alert('Erro ao buscar usuários: ' + error.message);
                setUsuarios([]);
            }
        }
        carregarUsuarios();
    }, []);

    return (
        <ul id="listaUsuarios" className="lista-usuarios">
            {usuarios.length === 0 ? (
                <li>Nenhum Prato encontrado.</li>
            ) : (
                usuarios.map(usuario => (
                    <li key={usuario.id}>
                        <strong>Nome do Prato:</strong> {usuario.nomePrato} <br />
                        <strong>Categoria:</strong> {usuario.categoria} <br />
                        <strong>Disponível:</strong> {usuario.disponivel} <br />                        
                        {usuario.urlImage && (
                            <>
                                <strong>Imagem:</strong><br />
                                <img 
                                    src={usuario.urlImage} 
                                    alt={usuario.nomePrato} 
                                    style={{ maxWidth: '200px', marginTop: '0.5rem', borderRadius: '8px' }} 
                                />
                            </>
                        )}
                    </li>
                ))
            )}
        </ul>
    );
}

export default ListaDeUsuarios;

