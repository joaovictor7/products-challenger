# 📱 Desafio Técnico - Aplicativo DummyJSON

Este projeto é uma solução para o desafio técnico de entrevista, que consiste na implementação de um aplicativo Android utilizando tecnologias modernas, arquitetura limpa e foco em boas práticas de desenvolvimento.

## 🧩 Funcionalidades Implementadas

✅ Listagem de produtos com paginação local e armazenamento offline\
✅ Requisição à API pública [DummyJSON](https://dummyjson.com/docs/products) com fallback para mock\
✅ Pesquisa avançada em tempo real (nome ou descrição, insensível a maiúsculas/minúsculas/acentos e ordem dos termos)\
✅ Tela de detalhe do produto com informações completas\
✅ Formulário validado com múltiplos campos e regras específicas\
✅ Suporte a múltiplos flavors de build para modularização do projeto\
✅ Adaptação automática ao tema do sistema (modo claro e escuro)

## 🏗️ Arquitetura e Abordagem

O projeto foi desenvolvido com base em:

- **MVI** (Model-View-Intent)
- **Clean Architecture** com camadas bem definidas (Data, Domain, Presentation)
- **Programação reativa** usando **Flow** e **Coroutines**
- **Jetpack Compose** para UI declarativa moderna

## 🧪 Bibliotecas Utilizadas

| Biblioteca            | Finalidade                                                             |
| --------------------- | ---------------------------------------------------------------------- |
| **Ktor Client**       | Realizar chamadas HTTP de forma flexível e moderna                     |
| **Room + SQLite**     | Persistência de dados localmente com suporte a transações e SQL direto |
| **Coil**              | Carregamento de imagens assíncrono e eficiente                         |
| **MockK**             | Framework de mocking leve e expressivo para testes                     |
| **JUnit5**            | Estrutura base de testes unitários                                     |
| **Hilt**              | Injeção de dependência padrão no Android moderno                       |
| **Flow + Coroutines** | Programação assíncrona e reativa                                       |
| **Kover**             | Medição de cobertura de testes com suporte para Kotlin                 |

Essas escolhas foram feitas visando manter o projeto moderno, testável, eficiente e compatível com os padrões de desenvolvimento Android atuais.

## 🔧 Configuração e Instalação

### Pré-requisitos

- Android Studio Hedgehog ou superior
- JDK 22

### Passo a passo:

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/dummyjson-challenge.git
cd dummyjson-challenge
```

2. Sincronize o projeto com o Gradle (Android Studio fará automaticamente)

3. Escolha um dos flavors e execute:

#### Flavors disponíveis:

- **Dimension **`Environment`**:**

  - `Develop`: ambiente local mockado, usando JSONs para simular API
  - `Staging`: ambiente de homologação, com dados reais da API DummyJSON

- **Dimension **`Distribution`**:**

  - `Form`: inicia o app diretamente na tela do formulário validado
  - `Products`: inicia na tela de listagem de produtos

### Exemplos de builds possíveis:

| Build Variant            | Descrição                       |
| ------------------------ | ------------------------------- |
| `developFormDebug`       | Mock local + Formulário         |
| `developProductsStaging` | API real + Listagem de Produtos |

## 🤔 Decisões Técnicas

- Utilização de **Room** ao invés de simples cache em memória para garantir persistência entre execuções.
- **Ktor** foi preferido ao Retrofit por sua flexibilidade e suporte multiplataforma.
- Modularização com flavors para separar responsabilidades (formulário vs. produtos).
- **Formulário validado** com regras específicas aplicadas via lógica de negócios e extensão functions.
- Sacrifício da implementação completa do flavor `Release` devido à prioridade nas funcionalidades principais.

## 📸 Telas Implementadas

- 🛍️ **Listagem de Produtos** com ícones de rating personalizados (<3, 3–4, >4)
- 🔍 **Pesquisa Avançada** com resultados dinâmicos
- 🧾 **Detalhe do Produto** com imagem responsiva e dados completos
- 📝 **Formulário Validado** com regras de data, código promocional, email e mais

## ✅ Testes

- Testes unitários foram implementados nas ViewModels
- Uso de `MockK` para simular dependências
- Cobertura de código monitorada via `Kover`

### 📊 Gerando relatório de cobertura com Kover

Para gerar o relatório HTML de cobertura de testes, execute o seguinte comando:

```bash
./gradlew koverHtmlReportProject
```

O relatório será gerado automaticamente na pasta:

```
/kover
```

Abra o arquivo `index.html` dentro dessa pasta para visualizar os resultados no navegador.

## 💬 Considerações Finais

🎯 Todos os requisitos do desafio foram implementados com foco em **qualidade de código**, **arquitetura limpa** e **experiência do usuário**.

⚠️ Apenas os flavors `Develop` e `Staging` estão disponíveis.

⚠️ Foi implementado testes unitários apenas em ViewModels.

