all: reader writer #compiles both files
reader: reader.cpp
	g++ -o reader reader.cpp
writer: writer.cpp
	g++ -o writer writer.cpp
clean:
	rm -f reader writer