package com.github.isuzuki

import caliban.GraphQL.graphQL
import caliban.RootResolver
import com.github.isuzuki.Schema.Queries
import zio.{ExitCode, URIO}

object Main extends zio.App {
  import Character._

  // resolver
  val queries = Queries(
    getCharacters,
    args => getCharacter(args.name)
  )

  val api = graphQL(RootResolver(queries))

  val query =
    """
      {
        characters {
          name
        }
      }
    """

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = {
    val result = for {
      interpreter <- api.interpreter
      result <- interpreter.execute(query)
      _ <- zio.console.putStrLn(result.toString)
    } yield result

    result.exitCode
  }
}
