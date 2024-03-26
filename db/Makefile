IMAGE_TAG_LATEST := game:latest
DB_SOURCES_DIR := db

run:
	docker build -t "$(IMAGE_TAG_LATEST)" "$(DB_SOURCES_DIR)"
	docker run --rm -it -p 5432:5432 "$(IMAGE_TAG_LATEST)"