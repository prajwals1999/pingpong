# PingPong

create 2 microservices services using Java, springboot. Use kafka opensource implementation to publish and subscribe events from both the services.

a.	Raise an event from service 1 via Kafka opensource implementation
b.	Receive the event from service 2 and once received, Then raise an event from the service 2 and receive it from service 1 and store it in DB.
c.	Keep doing this as a ping pong.
d.	Expose api’s to start and stop the events via the services

To start using Ping :
http://localhost:9000/kafka/ping?message=start
To stop using Ping :
http://localhost:9000/kafka/ping?message=stop

To start using Pong :
http://localhost:8000/kafka/pong?message=start
To stop using Pong :
http://localhost:8000/kafka/pong?message=stop
