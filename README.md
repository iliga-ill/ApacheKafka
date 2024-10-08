Локальный запуск сервера кафки:
D:\Desktop\kafkaServer>bin\windows\zookeeper-server-start.bat config\zookeeper.properties
D:\Desktop\kafkaServer>bin\windows\kafka-server-start.bat config\server.properties

bin\windows\kafka-console-consumer.bat --topic topic1 --from-beginning --bootstrap-server localhost:9092