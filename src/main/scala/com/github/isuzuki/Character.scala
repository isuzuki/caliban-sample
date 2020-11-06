package com.github.isuzuki

case class Character(
  name: String,
  age: Int
)

object Character {
  def getCharacters: List[Character] =
    List(
      Character("tom", 10),
      Character("hom", 20)
    )
  def getCharacter(name: String): Option[Character] =
    getCharacters.find(_.name == name)
}
