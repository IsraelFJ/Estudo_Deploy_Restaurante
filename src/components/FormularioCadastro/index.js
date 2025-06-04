import { useState } from "react";
import './styles.css';
import { useNavigate } from "react-router-dom";
import useMensagem from '../../hooks/useMensagem';
import MensagemFeedback from '../MensagemFeedback';
import logo from '../../assets/images/logo.png';
import axios from 'axios';

function FormularioCadastro() {
    const [nomePrato, setNomePrato] = useState('');
    const [categoria, setCategoria] = useState('');
    const [preco, setPreco] = useState('');
    const [disponivel, setDisponivel] = useState('');
    const [urlImage, setUrlImage] = useState('');
    const navigate = useNavigate();
    const { exibirMensagem , mensagem, tipoMensagem, visivel, fecharMensagem } = useMensagem();

    const cadastrarUsuario = async () => {
        try {
            const response = await axios.post('https://deploy-restaurante.onrender.com', {
                nomePrato,
                categoria,
                disponivel,
                preco,
                urlImage
            });

            exibirMensagem(response.data.mensagem || 'Usuário cadastrado com sucesso!', 'sucesso');

            // Limpar campos
            setNomePrato('');
            setCategoria('');
            setDisponivel('');
            setUrlImage('');

            navigate('/usuarios');
        } catch (error) {
            let erroMsg = 'Erro ao conectar ao servidor.';
            if (error.response && error.response.data) {
                erroMsg = error.response.data.mensagem;
                if (error.response.data.erros) {
                    erroMsg += ' ' + Object.values(error.response.data.erros).join(', ');
                }
            }
            exibirMensagem(erroMsg, 'erro');
        }
    }

    return (
        <div className="container">
            <img src={logo} alt="Logo da empresa" />
            <h2>Cadastre seu Prato</h2>
            <form onSubmit={(e) => { e.preventDefault(); cadastrarUsuario(); }}>
                <input 
                    type="text"
                    id="nomePrato"
                    placeholder="Nome do Produto"
                    value={nomePrato}
                    onChange={(e) => setNomePrato(e.target.value)}
                    required
                />
                 <input 
                    type="number"
                    id="preco"
                    placeholder="Preço do Produto"
                    value={preco}
                    onChange={(e) => setPreco(e.target.value)}
                    required
                    step="0.01" // permite centavos
                    min="0"
                />          
                <input 
                    type="text"
                    id="urlImage"
                    placeholder="URL da Imagem"
                    value={urlImage}
                    onChange={(e) => setUrlImage(e.target.value)}
                    required
                />

                <div className="disponivel-container">
                    <label htmlFor="disponivel">Disponível</label>
                    <select 
                        id="disponivel" 
                        value={disponivel} 
                        onChange={(e) => setDisponivel(e.target.value)} 
                        required
                    >
                        <option value="">Selecione</option>
                        <option value="SIM">Sim</option>
                        <option value="NAO">Não</option>
                    </select>
                </div>

                <div className="categoria-container">
                    <label htmlFor="categoria">Categoria</label>
                    <select 
                        id="categoria" 
                        value={categoria} 
                        onChange={(e) => setCategoria(e.target.value)} 
                        required
                    >
                        <option value="">Selecione</option>
                        <option value="ENTRADA">Entrada</option>
                        <option value="BEBIDA">Bebida</option>
                        <option value="PRATO_PRINCIPAL">Prato Principal</option>
                        <option value="SOBREMESA">Sobremesa</option>
                    </select>
                </div>

                <button type="submit">Cadastrar</button>
            </form>
            <div className="bottom_new"> 
            <button onClick={() => navigate('/usuarios')} className="link-usuarios">
                Ver usuários cadastrados
            </button>
            <button onClick={() => navigate('/')} className="link-pagina-incial">
                Home
            </button>
            </div>
            <MensagemFeedback
                mensagem={mensagem}
                tipo={tipoMensagem}
                visivel={visivel}
                onClose={fecharMensagem}
            />
        </div>
    );
}

export default FormularioCadastro;
