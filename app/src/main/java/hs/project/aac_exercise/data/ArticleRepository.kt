package hs.project.aac_exercise.data

import hs.project.aac_exercise.data.Article
import hs.project.aac_exercise.data.ArticlePagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.time.LocalDateTime

private val firstArticleCreatedTime = LocalDateTime.now()

class ArticleRepository {

    val articleStream: Flow<List<Article>> = flowOf(
        (0..500).map { number ->
            Article(
                id = number,
                title = "Article $number",
                description = "This describes article $number",
                created = firstArticleCreatedTime.minusDays(number.toLong())
            )
        }
    )

    fun articlePagingSource() = ArticlePagingSource()
}
