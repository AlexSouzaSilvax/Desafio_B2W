# Desafio_B2W

<h4 align="center">
  API Desenvolvida com Java, desafio B2W.
</h4>

<br>

## 📜 Documentação

     Adicionar um planeta (nome, clima e terreno)
     - POST
     - /Desafio_B2W/api/planetas/novo 
     - Body: {        
	        "nome": "NOME_PLANETA",
	        "clima": "CLIMA_PLANETA",
	        "terreno": "TERRENO_PLANETA"
        }
     
     
     Listar todos os planetas
     - GET
     - /Desafio_B2W/api/planetas/listar     
     
     
     Buscar planeta por nome
     - GET
     - /Desafio_B2W/api/planetas/buscarPorNome
     - Headers: [
                  {
                      "nome": "Hoth"
                  }
                ]
      
      
     Buscar planeta por id
     - GET
     - /Desafio_B2W/api/planetas/buscarPorId
     - Headers: [
                  {
                      "id": "5f332c5fcb69c17243279425"
                  }
                ]
      
      
     Remover planeta
     - GET
     - /Desafio_B2W/api/planetas/remover
     - Headers: [
                  {
                      "id": "5f332c5fcb69c17243279425"
                  }
                ]


<br>

## 💻 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- [Java](https://www.java.com/pt_BR/)
- [MongoDB](https://www.mongodb.com/)
