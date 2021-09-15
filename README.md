# Número por extenso
Projeto para obter número por extenso na faixa de -999999 a 99999

O Numero por extenso se trata de um sistema sob arquitetura Java/Spring Boot configurado com Maven para disponibilização de um serviço HTTP. 

# 1 - Compilar com Maven e executar local com java -gar
## 1.1 Pre-requisistos
Para construir e rodaar a aplicação você precisa de:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3.6.3](https://maven.apache.org)

## 1.2 Passo a passo
1.2.1 - [Baixar o projeto](https://github.com/ronybrand/numero_por_extenso/archive/feature/numero_por_extenso.zip)

1.2.2 - Descompacte o zip, entre no diretório descompactado e execute na linha de comando:
```
mvn package
```

1.2.3 - Rodar
- Para rodar usando a porta padrão do projeto (8080), execue o comando abaixo:
```
java -jar target\numero-por_extenso-0.0.1-SNAPSHOT.jar
```

- Caso já tenha outro serviço rodando nesta porta (como meu caso). Informe a porta na tag abaixo ex: 8090
```
java -jar -Dserver.port=<porta> target\numero-por_extenso-0.0.1-SNAPSHOT.jar
```
1.2.4 - Abra um navegador e obtenha os números por extenso através da URL demonstrada abaixo. 
- Infome a porta escolhida no passo anterior.
- Informe o número que deseja por extenso. Lembre-se da faixa na descrição do projeto.
```
http://localhost:<porta>/<numero>
```
  
# 2- Bônus - Rodar Docker/Java
## 2.1 Pré-requisitos
Para rodar a aplicação com docker você precisa de:
- [JDK 1.8 ou superior](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Docker](https://docs.docker.com/install/)
- <Ip_docker> Se já souber pode pular para o 2.2. Caso contrário, obtenha o IP do container docker com o comando abaixo:
```
docker-machile ls 
```

## 2.2 Passo a passo
2.2.1 - informe a porta-externa que deseja que o projeto rode, ex: 8090. Esta porta não pode estar sendo utilizada por outro serviço.
```
docker run -p <porta-externa>:8080 -t ronybrand/numero_por_extenso
```

2.2.2 - Abra um navegador e obtenha os números por extenso através da URL demonstrada abaixo.
- Informe o Ip_docker cfe item 2.1.
- Informe a porta-externa cfe item 2.2.1.
- Informe número que deseja por extenso. De novo de acordo com a faixa na descrição do projeto :)
```
http://<Ip_docker>:<porta-externa>/<numero>
```
# 3 - Postman
Para obter número por extenso pelo postman:
- [Postman](https://www.postman.com/downloads/)

Importar coleção de testes (contido no item 1.2.1 - <dir_projeto>/src/test/postman):
![Importar o projeto no postman](https://github.com/ronybrand/numero_por_extenso/blob/feature/numero_por_extenso/importar_projeto_postman.png)

Após importar, aparecerão os seguintes testes:
![Executar testes](https://github.com/ronybrand/numero_por_extenso/blob/feature/numero_por_extenso/testes_postman.png)

Exemplo Requisição:
![Exemplo requisição](https://github.com/ronybrand/numero_por_extenso/blob/feature/numero_por_extenso/exemplo_requisicao.png)
- Informe "locahost" caso tenha rodado com Maven/Java ou o "ip_docker" caso tenha executado com Docker/Java.
- Informe a porta escolhida de acordo com a opção acima.
- Quando hover a tag numero_positivo ou numero_negativo informe número que deseja por extenso.
- Clique em "Send"

Exemplo de resultado:
![Exemplo requisição](https://github.com/ronybrand/numero_por_extenso/blob/feature/numero_por_extenso/exemplo_resultado.png)
