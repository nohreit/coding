#include "character.h"
#include "iostream"
#include "time.h"

using namespace std;

Character::Character() // Default character
{
    this->id = clock();
    this->hp = 100;
    this->mp = 0;
    this->sp = 0;
    this->atk = 0;
    this->def = 0;
    this->matk = 0;
    this->mdef = 0;
    this->luk = 0;
    this->agi = 0;
    this->description = "";
}

Character::Character(int hp, int mp, int sp, int atk, int def, int matk, int mdef,
                     int luk, int agi, string description){
    this->id = clock();
    this->hp = hp;
    this->mp = mp;
    this->sp = sp;
    this->atk = atk;
    this->def = def;
    this->matk = matk;
    this->mdef = mdef;
    this->luk = luk;
    this->agi = agi;
    this->description = description;
}

bool Character::isAlive(){return this->hp>0;}
bool Character::hasEnoughMP(Magic *magic){return magic->mpNeeded < this->mp;}
bool Character::hasEnoughSP(Skill *skill){return skill->spNeeded < this->sp;} //accessor for spNeeded


void Character::attacks(Character*){}
void Character::defense(int){}
void Character::castsMagic(Character*){}
void Character::usesSkill(Character*){}
void Character::usesItem(Item*, Character*){}
void Character::moves(){}
void Character::escapes(){}
void Character::surrenders(){}
void Character::info(){}

//accessors
int Character::getId(){return this->id;}
int Character::getHp(){return this->hp;}
int Character::getMp(){return this->mp;}
int Character::getSp(){return this->sp;}
int Character::getAtk(){return this->atk;}
int Character::getDef(){return this->def;}
int Character::getMatk(){return this->matk;}
int Character::getMdef(){return this->mdef;}
int Character::getLuk(){return this->luk;}
int Character::getAgi(){return this->agi;}

//void Character::setId(){return this->}
void Character::setHp(int hp){this->hp = hp;}
void Character::setMp(int mp){this->mp = mp;}
void Character::setSp(int sp){this->sp = sp;}
void Character::setAtk(int atk){this->atk = atk;}
void Character::setDef(int def){this->def = def;}
void Character::setMatk(int matk){this->matk = matk;}
void Character::setMdef(int mdef){this->mdef = mdef;}
void Character::setLuk(int luk){this->luk = luk;}
void Character::setAgi(int agi){this->agi = agi;}
