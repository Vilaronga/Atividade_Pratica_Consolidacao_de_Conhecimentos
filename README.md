## 🚀 Como Rodar o Projeto via GitHub

Certifique-se de ter o seguintes pré-requisitos instalados:

### Pré-requisitos
* [Git](https://git-scm.com)
* [Java 21 - LTS](https://adoptium.net/pt-BR/temurin/releases?version=21&os=any&arch=any)
* [PostgreSQL 18](https://www.postgresql.org/download/)

---

### 1. Clonar o Repositório
Abra o terminal na pasta onde deseja salvar o projeto e execute o comando abaixo:
```bash
git clone <https://github.com/Vilaronga/Atividade_Pratica_Consolidacao_de_Conhecimentos>
```

Abra o projeto com sua IDE de preferência.

### 2. Configurar as Variáveis de Ambiente na IDE
O passo a passo a seguir é focado na IDE [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/). Caso utilize outra, verifique como criar variáveis de ambiente na sua IDE ou crie um arquivo .env.

1. Na sua IDE, vá no menu principal ```Alt + \```.
2. Vá em ```Run``` -> ```Edit Configurations...```:
3. Caso esteja vazio, clique no mais ou  ```Alt + Insert``` e adicione uma configuração ```Spring Boot```.
4. Clique em ```Modify Options``` -> ```Environment Variables```.
5. No campo que apareceu, crie as seguintes variáveis de ambiente:
```ini
dbname=$1;dbuser=$2;dbpass=$3
```
> 💡 **Nota:** 
> 
> Substitua: \
> ```$1``` Pelo nome do seu banco.\
> ```$2``` Pelo nome do seu usuário do banco. \
> ```$3``` Pela senha do seu usuário do banco. 

### 3. Executar o Projeto
Agora basta inicializar pela própria IDE o arquivo:
```bash
ConsolidacaoDeConhecimentosApplication
```

> 💡 **Nota:** Em breve atualizarei para Docker.

### 4. Acessar a Aplicação
Após inicializar o projeto e subir o PostgreSQL, a aplicação estará disponível em:
* **API / Web:** `http://localhost:8080`
* **Banco de Dados (PostgreSQL):** Porta local padrão: `5432` 

> 🤖 **Teste os Endpoints:**
>
> * **WEB:** http://localhost:8080/swagger-ui/index.html
