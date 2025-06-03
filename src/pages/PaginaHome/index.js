import { useNavigate } from 'react-router-dom';
import './styles.css';

function PaginaHome() {  // Aqui, o nome do componente deve ser PaginaHome
    const navigate = useNavigate();

    return (
        <div className='pagina-home'>
            <div className='home-container'>
                <h1>Bem-vindo ao Restaurante</h1>
                
                <button onClick={() => navigate('/cadastro')} className='cadastrar-novo-usuario'>
                    Cadastrar Novo Prato
                </button>
                <button onClick={() => navigate('/usuarios')} className='cadastrar-novo-usuario'>
                    Ver Pratos Cadastrados
                </button>
            </div>
        </div>
    );
}

export default PaginaHome;  // Corrigir o nome aqui também para exportar PaginaHome
