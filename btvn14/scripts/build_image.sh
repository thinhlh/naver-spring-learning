./mvnw clean package

 docker build --platform linux/amd64 -t venetus/naver-btvn14 .

docker push venetus/naver-btvn14