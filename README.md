# ProjectSRC

Project made for ILC(Instituto Politécnico de Leiria).
A Chat Application with focus on Cibersecurity. Uses both symmetric and assymetric encryption to make communication secure.

How it works:

  1- Start server app

  2- Start client (client will  estabilish communication using a server certificate)

  3- Client sends PuB Key info 

  4- Server stores PuB key in a keystore

  5- Client joints a room

    .1- if the client is the first in the room he creates a secret private key 
  
  6- When another client joins room  the secret private key is exancheged using the clients PuB key.

  7- Secret private Key is only valid while there are clients in the room 

Advantages: 

  Server doesnt store information regarding communications

  Focus on end-to-end encryption -> server cant see info sent by a client

  Lightweight communication with security

Needs Improvament: 

  Communication is currently made by tcp instead of udp -> would improve server performance 
  

Made by : 
  
  António Filipe Bento Barros https://www.linkedin.com/in/ant%C3%B3nio-barros-5645471a3/

  Tiézer de Costa Melo https://www.linkedin.com/in/tiezercostademelo/
