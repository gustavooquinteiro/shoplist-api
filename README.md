# shoplist-api
Shoplist API with Java Spring Boot


# Endpoints

### POST Criar Produto `/produtos`
```json
{
  "nome": "nome_do_produto"
}
```

Retorna:

```json
{
  "nome": "nome_do_produto",
  "precos": []
}
```

### POST Criar Mercado `/mercados`
```json
{
  "nome": "nome_do_mercado"
}
```

Retorna: 

```json
{
  "nome": "nome_do_mercado",
  "endereco": null
}
```

### GET Listagem de produto `/produtos`
Retorna:
```json
[
  {
    "nome": "nome_do_produto",
    "precos": [
      {
        "mercado": {
          "nome": "nome_do_mercado",
          "endereco": null
          },
          "valor": valor_do_produto_no_mercado
      },
      {
        "mercado": {
          "nome": "nome_do_mercado",
          "endereco": null
        },
        "valor": valor_do_produto_no_mercado
      },
    ...
    ]
  },
  ...
]
```
### GET Listagem de mercado `/mercados`
Retorna:
```json
[
  {
    "nome": "nome_mercado_1",
    "endereco": {
    }
  },
  {
    "nome": "nome_mercado_2",
    "endereco": {
    }
  },
  ...
]
```

### POST Adicionar preço `/precos`
```json
  "mercadoId": mercado_id,
  "produtoId": produto_id,
  "valor": preco_do_produto
```

Retorna:
```json
{
  "nomeProduto": "nome_do_produto",
  "mercado": {
    "nome": "nome_do_mercado",
    "endereco": null
  },
  "valor": preco_produto
}
```



### POST Criar Lista de Compras `/lista`
Retorna:
```json
{
  "id": listaID,
  "itens": [],
  "valorTotal": 0.0
}
```
### POST Criar Lista de Compras `/lista/{listaID}`
```json
{
  "nome": "nome_do_produto",
  "quantidade": quantidade
}
```

Retorna:
```json
{
  "id": 1,
  "itens": [
    {
      "id": produto_id,
      "produto": {
        "nome": "nome_do_produto",
        "precos": [
          {
            "mercado": {
              "nome": "nome_do_mercado",
              "endereco": null
            },
            "valor": preco_do_produto_no_mercado
          },
          ...
      ]
    },
    "menorValor": menor_valor_do_produto,
    "quantidade": quantidade_do_produto
  },
  ...
  ],
  "valorTotal": valor_total_da_lista_de_compras
}
```
