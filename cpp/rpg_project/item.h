#ifndef ITEM_H
#define ITEM_H

#include <iostream>

using namespace std;

class Item
{
private:
    int id;
    string name;
    int effectValue;
    string description;
    int count;

public:
    Item();
    void info();

};

#endif // ITEMS_H
