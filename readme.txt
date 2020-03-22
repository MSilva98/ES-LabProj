#Lab Project l30

This lab project is a simple project that presents the Heathrow Airport departing flights from the last day and half.

## Team

Diogo Marques 83631 d.marques@ua.pt
Marco Silva 84770 masilva@ua.pt

##How to deploy and use it


1. Change the ip on kafka files (KafkaTopicConfig.java, KafkaConsumerConfig.java, KafkaProducer.java) to the IP of your machine
2. Run spotify/kafka
	docker run -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=xxx.xxx.xxx.xxx --env ADVERTISED_PORT=9092 spotify/kafka
	where xxx.xxx.xxx.xxx is the IP of your machine
3. mvn package 
4. docker build -t labproj .
	Inside the ES-LabProj folder (where Dockerfile is)
5. Run jar image deployed in docker
	docker run -p 8082:8082 -t labproj
6. To visualize the contents retrieved from the API open in any browser the following link
	localhost:8082
