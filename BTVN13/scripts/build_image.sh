./mvnw clean package

 docker build --platform linux/amd64 -t venetus/naver-btvn13 .

docker push venetus/naver-btvn13