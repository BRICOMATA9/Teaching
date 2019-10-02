all: musicinfo

musicinfo: obj/info.o obj/main.o
	gcc -o musicinfo obj/info.o obj/main.o

obj/info.o: src/info.c src/info.h
	gcc -o obj/info.o -c src/info.c -W -Wall

obj/main.o: src/main.c src/info.h
	gcc -o obj/main.o -c src/main.c -W -Wall

clean:
	rm -rf obj/*.o

mrproper: clean
	rm -rf musicinfo

.PHONY: clean, mrproper
