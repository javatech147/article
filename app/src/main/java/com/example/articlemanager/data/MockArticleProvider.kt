package com.example.articlemanager.data

import com.example.articlemanager.presentation.model.Article

object MockArticleProvider {
    val articles = listOf(
        Article(
            id = 3309047,
            title = "What was your win this week??",
            description = "Looking back on your week -- what was something you're proud of?  All wins count -- big or...",
            imageUrl = null
        ),
        Article(
            id = 3373361,
            title = "Get Started on Dev.to! A Beginner's Guide to Engage with the Community!",
            description = "All Images are own by the Pokemon Company!  Important Information: This post is an Unofficial Dev.to...",
            imageUrl = null
        ),
        Article(
            id = 3381615,
            title = "OpenTelemetry just standardized LLM tracing. Here's what it actually looks like in code.",
            description = "Every LLM tool invents its own tracing format. Langfuse has one. Helicone has one. Arize has one. If...",
            imageUrl = null
        ),
        Article(
            id = 3377303,
            title = "My AI agent messed up a UTC time conversion algorithm after I *specifically told it* to make no mistakes. smh",
            description = "A post by Ben Halpern",
            imageUrl = null
        )
    )
}