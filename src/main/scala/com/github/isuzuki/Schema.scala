package com.github.isuzuki

object Schema {
  case class CharacterName(name: String)
  case class Queries(
    characters: List[Character],
    character: CharacterName => Option[Character]
  )
}
