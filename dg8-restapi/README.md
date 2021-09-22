# Infinispan Pokemon

This demo uses the query and REST capabilities of Infinispan Server 10 to help you battle Pokemons!

Data is ingested as JSON, and internally stored efficiently as Protobuf. Both query and retrieval happens using JSON
taking advantage of the mapping between Protobuf and JSON present in Infinispan

## Requirements

* Download the dataset ```pokemon.zip``` from https://www.kaggle.com/rounakbanik/pokemon
* Make sure Python 3 installed ```python --version```

## Running 

* Start Infinispan 12.1:

  ```docker run -it --name infinispan-server -p 11222:11222 -e "USER=admin" -e "PASS=password" infinispan/server:12.1.7.Final```

* Register the protobuf schema
  
  ```curl -u developer:NdFINF2E3CmRMbN3 -X POST --data-binary @./pokemon.proto $EP/rest/v2/schemas/pokemon.proto```

* Prepare data

  ```python3 prepare-data.py```
  
* Creating an indexed cache

  ``` curl -u developer:NdFINF2E3CmRMbN3 -H "Content-Type: application/json" -d '{"distributed-cache": {"mode": "SYNC","encoding": {"media-type": "application/x-protostream"},"indexing": {"indexed-entities": ["Pokemon"],"enabled": true},"statistics": true}}' $EP/rest/v2/caches/pokemon```

* Ingest data

   ``` ./ingest-data.sh```
   
## Querying

Example queries:

* Get Pokemon by key (name)

    [$EP/rest/v2/caches/pokemon1/Whismur]($EP/rest/v2/caches/pokemon1/Whismur)

* Get all Pokemons: 
  
   [from Pokemon]($EP/rest/v2/caches/pokemon?action=search&query=from%20Pokemon1)
   
* Count Pokemons by generation:

   [select count(p.name) from Pokemon group by generation]($EP/rest/v2/caches/pokemon1?action=search&query=select%20count(p.name)%20from%20Pokemon%20p%20group%20by%20generation)
   
* Do a full text search on the name

  [from Pokemon where name:'pikachu']($EP/rest/v2/caches/pokemon1?action=search&query=from%20Pokemon%20where%20name:%27pikachu%27)
  
* Select top 5 Pokemons that can better withstand fire:

  [from Pokemon order by against_fire]($EP/rest/v2/caches/pokemon1?action=search&query=from%20Pokemon%20order%20by%20against_fire%20asc&max_results=5)

