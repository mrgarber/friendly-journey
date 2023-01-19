/****
 * Programer: Matthew Garber
 * Purpose: reader.cpp file is used to ouput numbers in a
 *          binary file to the command line.
****/
#include <iostream>
#include <fstream>
using namespace std;

int main(int argc, char** argv) {
    ifstream ifile;
    ifile.open(argv[1], ios::binary); //reads in binary file
    char* binaryFile = argv[1];
    if (!ifile) { //checks binary file argument  
        cout << "Error: Invalid File" << binaryFile << endl;
        return 1; //returns if File is invalid
    } 
    int data;
    while (ifile.read((char*) &data, sizeof(data))) { //while there is data, print it out
        cout << data << endl;
    }
    ifile.close();
    return 0;
}