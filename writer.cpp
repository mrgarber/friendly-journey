/****
 * Programer: Matthew Garber
 * Purpose: writer.cpp file is used to write numbers given by a user
 *          in the command line to a binary file. 
****/
#include <iostream>
#include <fstream>
using namespace std;

void writeToBinaryFile(ofstream& file, int num){ //writes to binary file
    file.write((char*) &num, sizeof(num));
}

int main(int argc, char** argv) {
    int num;
    ofstream ofile;
    ofile.open(argv[1], ios::binary | ios::in | ios::out); //reads binary file with previous data
    char* binaryFile = argv[1];
    if (!ofile) { //checks binary file argument  
        cout << "Error: Invalid File" << binaryFile << endl;
        return 1; //returns if arguments are invalid
    } 
    cout << "Enter number to add to file or -1 to quit>";
    cin >> num;
    ofile.seekp(0, ios::beg); //moves pointer back to beginning 
    while (num != -1) { //loops until -1 is entered from user
        writeToBinaryFile(ofile, num); //calls function to write to binary file
        cout << "Enter number to add to file or -1 to quit>";
        cin >> num; //user input
    }
    ofile.close();
    return 0;
}
