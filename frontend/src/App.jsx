import { useState, useEffect } from 'react'
import axios from 'axios'

// Configuração da conexão com o Java (Backend)
const api = axios.create({
  baseURL: 'http://localhost:8080',
  auth: {
    username: 'admin', 
    password: '123'
  }
})

function App() {
  const [alunos, setAlunos] = useState([])
  const [novoAluno, setNovoAluno] = useState({ nome: '', matricula: '', email: '' })

  useEffect(() => {
    carregarAlunos()
  }, [])

  function carregarAlunos() {
    api.get('/alunos')
      .then(response => setAlunos(response.data))
      .catch(error => console.error("Erro ao conectar no Java:", error))
  }

  function salvarAluno(e) {
    e.preventDefault()
    api.post('/alunos', novoAluno)
      .then(() => {
        alert("Aluno salvo com sucesso!")
        setNovoAluno({ nome: '', matricula: '', email: '' })
        carregarAlunos()
      })
      .catch(error => alert("Erro ao salvar! Verifique se o Java está rodando ou se há erro no console."))
  }

  return (
    // CONTAINER PRINCIPAL: Centraliza o conteúdo e define largura máxima
    <div style={{ 
        padding: '20px', 
        fontFamily: 'Arial', 
        maxWidth: '800px', 
        margin: '0 auto', 
        backgroundColor: '#f9f9f9' 
    }}>
      <h1 style={{ textAlign: 'center', color: '#333' }}>🎓 Sistema Acadêmico</h1>
      
      {/* CARD DE CADASTRO */}
      <div style={{ 
          background: '#fff', 
          padding: '20px', 
          borderRadius: '10px', 
          marginBottom: '30px', 
          boxShadow: '0 4px 8px rgba(0,0,0,0.1)'
      }}>
        <h2 style={{ borderBottom: '2px solid #ccc', paddingBottom: '10px', color: '#555' }}>Cadastrar Aluno</h2>
        <form onSubmit={salvarAluno} style={{ display: 'flex', gap: '10px', flexWrap: 'wrap' }}>
          <input 
            placeholder="Nome" 
            value={novoAluno.nome} 
            onChange={e => setNovoAluno({...novoAluno, nome: e.target.value})} 
            required 
            style={{ flex: '1', minWidth: '150px', padding: '10px', border: '1px solid #ccc', borderRadius: '5px' }}
          />
          <input 
            placeholder="Matrícula" 
            value={novoAluno.matricula} 
            onChange={e => setNovoAluno({...novoAluno, matricula: e.target.value})} 
            required 
            style={{ flex: '1', minWidth: '150px', padding: '10px', border: '1px solid #ccc', borderRadius: '5px' }}
          />
          <input 
            placeholder="Email" 
            value={novoAluno.email} 
            onChange={e => setNovoAluno({...novoAluno, email: e.target.value})} 
            required 
            style={{ flex: '1', minWidth: '150px', padding: '10px', border: '1px solid #ccc', borderRadius: '5px' }}
          />
          <button 
            type="submit" 
            style={{ 
              background: '#007bff', 
              color: 'white', 
              border: 'none', 
              padding: '10px 15px', 
              cursor: 'pointer', 
              borderRadius: '5px' 
            }}
          >
            SALVAR
          </button>
        </form>
      </div>

      {/* LISTA DE ALUNOS */}
      <h2 style={{ color: '#555' }}>Lista de Alunos</h2>
      <ul style={{ listStyle: 'none', padding: 0 }}>
        {alunos.length === 0 ? (
          <li style={{ color: '#999', padding: '15px' }}>Nenhum aluno cadastrado.</li>
        ) : (
          alunos.map(aluno => (
            // LIST ITEM: Estilo ajustado para garantir que o texto apareça em qualquer fundo (branco)
            <li key={aluno.id} style={{ 
                padding: '15px', 
                borderBottom: '1px solid #eee', 
                backgroundColor: '#fff', 
                color: '#333', // Cor do TEXTO definida para o preto (garantindo visibilidade)
                borderRadius: '5px',
                marginBottom: '8px',
                boxShadow: '0 1px 3px rgba(0,0,0,0.05)'
            }}>
              <strong>{aluno.nome}</strong> | Matrícula: {aluno.matricula} ({aluno.email})
            </li>
          ))
        )}
      </ul>
    </div>
  )
}

export default App