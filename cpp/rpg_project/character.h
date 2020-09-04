#ifndef CHARACTER_H
#define CHARACTER_H

#include <iostream>
#include "item.h"
#include "magic.h"
#include "skill.h"

using namespace std;

class Character
{
private:
    int id;
    int hp;
    int mp;
    int sp;
    int atk;
    int def;
    int matk;
    int mdef;
    int luk;
    int agi;
    bool isAlive();
    bool hasEnoughMP(Magic*);
    bool hasEnoughSP(Skill*);
    string description;
public:
    Character();
    Character(int, int, int, int, int, int, int, int, int, string);
    void attacks(Character*);
    void defense(int);
    void castsMagic(Character*);
    void usesSkill(Character*);
    void usesItem(Item*, Character*);
    void moves();
    void escapes();
    void surrenders();
    void info();

    //accessors
    int getId();
    int getHp();
    int getMp();
    int getSp();
    int getAtk();
    int getDef();
    int getMatk();
    int getMdef();
    int getLuk();
    int getAgi();

//    void setId();
    void setHp(int);
    void setMp(int);
    void setSp(int);
    void setAtk(int);
    void setDef(int);
    void setMatk(int);
    void setMdef(int);
    void setLuk(int);
    void setAgi(int);

};

#endif // CHARACTER_H
