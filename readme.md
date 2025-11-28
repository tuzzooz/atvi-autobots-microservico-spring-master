Requisitos
- Java 17 (JDK) instalado e `JAVA_HOME` configurado.
- Maven (o projeto inclui `mvnw` — recomenda-se usar o wrapper).

Executando (PowerShell)
```powershell
# definir JAVA_HOME apenas para a sessão (se necessário)
$env:JAVA_HOME = 'C:\Program Files\Java\jdk-17'
cd 'C:\dev\atvi-project\automanager'
.\mvnw.cmd spring-boot:run
```

Executando (CMD)
```
cd "C:\dev\atvi-project\automanager"
set "JAVA_HOME=C:\Program Files\Java\jdk-17"
mvnw.cmd spring-boot:run
```

Gerar JAR e executar
```powershell
cd 'C:\dev\atvi-project\automanager'
.\mvnw.cmd clean package
$jar = Get-ChildItem -Path .\target -Filter '*.jar' | Where-Object { $_.Name -notlike '*original*' } | Select-Object -Last 1
java -jar $jar.FullName
```

Nota sobre caminhos
- Evite executar o projeto em pastas com parênteses ou caracteres especiais (ex.: " (1)"), pois o wrapper pode interpretar incorretamente scripts internos. Se necessário, copie o repositório para um caminho simples, ex.: `C:\dev\atvi-project`.

Endpoints (base: `http://localhost:8080`)

Cliente
- GET  `/cliente/cliente/{id}`
- GET  `/cliente/clientes`
- POST `/cliente/cadastro`          (body: JSON `Cliente`)
- PUT  `/cliente/atualizar`         (body: JSON `Cliente` com `id`)
- DELETE `/cliente/excluir`         (body: JSON com `id`)

Documento
- GET  `/documento/documento/{id}`
- GET  `/documento/documentos`
- POST `/documento/cadastro`
- PUT  `/documento/atualizar`
- DELETE `/documento/excluir`

Endereço
- GET  `/endereco/endereco/{id}`
- GET  `/endereco/enderecos`
- POST `/endereco/cadastro`
- PUT  `/endereco/atualizar`
- DELETE `/endereco/excluir`

Telefone
- GET  `/telefone/telefone/{id}`
- GET  `/telefone/telefones`
- POST `/telefone/cadastro`
- PUT  `/telefone/atualizar`
- DELETE `/telefone/excluir`

Exemplos curl
- Inserir cliente (exemplo mínimo):
```bash
curl -X POST http://localhost:8080/cliente/cadastro -H "Content-Type: application/json" -d '{"nome":"João Silva","nomeSocial":"","dataCadastro":"2025-11-28T12:00:00Z"}'
```
- Listar clientes:
```bash
curl http://localhost:8080/cliente/clientes
```