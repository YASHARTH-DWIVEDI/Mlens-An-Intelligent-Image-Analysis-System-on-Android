package com.mlens.app.ml

class TextSummarizer {
    
    fun summarizeTextAdvanced(text: String): String {
        if (text.isBlank() || text.length < 20) return text
        
        return try {
            // Use multiple summarization techniques
            val extractiveSummary = extractiveSummarizationAdvanced(text)
            val keywordSummary = keywordBasedSummary(text)
            val structuralSummary = structuralSummary(text)
            
            // Choose best summary based on content type
            chooseBestSummary(text, extractiveSummary, keywordSummary, structuralSummary)
        } catch (e: Exception) {
            // Fallback to simple summarization
            summarizeText(text) ?: text.take(200)
        }
    }
    
    private fun extractiveSummarizationAdvanced(text: String): String {
        val sentences = text.split(Regex("[.!?]+")).map { it.trim() }.filter { it.isNotEmpty() }
        if (sentences.size <= 2) return text
        
        // Score sentences based on multiple factors
        val sentenceScores = sentences.map { sentence ->
            var score = 0.0
            
            // Length score (prefer medium-length sentences)
            val lengthScore = when {
                sentence.length in 20..100 -> 1.0
                sentence.length in 10..150 -> 0.7
                else -> 0.3
            }
            score += lengthScore
            
            // Position score (first and last sentences often important)
            val position = sentences.indexOf(sentence)
            val positionScore = when {
                position == 0 -> 0.8
                position == sentences.size - 1 -> 0.6
                position < sentences.size / 3 -> 0.7
                else -> 0.4
            }
            score += positionScore
            
            // Keyword density score
            val keywords = extractKeywords(text)
            val keywordCount = keywords.count { keyword ->
                sentence.contains(keyword, ignoreCase = true)
            }
            val keywordScore = (keywordCount.toDouble() / keywords.size) * 2.0
            score += keywordScore
            
            // Numerical data score (numbers often important)
            val numberCount = sentence.count { it.isDigit() }
            val numberScore = if (numberCount > 0) 0.5 else 0.0
            score += numberScore
            
            sentence to score
        }
        
        // Select top sentences
        val topSentences = sentenceScores
            .sortedByDescending { it.second }
            .take(minOf(3, sentences.size / 2))
            .sortedBy { sentences.indexOf(it.first) }
            .map { it.first }
        
        return topSentences.joinToString(". ") + if (!topSentences.last().endsWith(".")) "." else ""
    }
    
    private fun keywordBasedSummary(text: String): String {
        val keywords = extractKeywords(text)
        val sentences = text.split(Regex("[.!?]+")).map { it.trim() }.filter { it.isNotEmpty() }
        
        if (keywords.isEmpty() || sentences.isEmpty()) return text
        
        // Find sentences with highest keyword density
        val keywordSentences = sentences.filter { sentence ->
            keywords.any { keyword ->
                sentence.contains(keyword, ignoreCase = true)
            }
        }.take(3)
        
        return if (keywordSentences.isNotEmpty()) {
            "Key points: " + keywordSentences.joinToString(". ")
        } else {
            text.take(200) + if (text.length > 200) "..." else ""
        }
    }
    
    private fun structuralSummary(text: String): String {
        // Detect document structure and summarize accordingly
        return when {
            isInvoiceOrReceipt(text) -> summarizeInvoice(text)
            isBusinessCard(text) -> summarizeBusinessCard(text)
            isLetter(text) -> summarizeLetter(text)
            isMenu(text) -> summarizeMenu(text)
            isCertificate(text) -> summarizeCertificate(text)
            else -> extractiveSummarizationAdvanced(text)
        }
    }
    
    private fun chooseBestSummary(
        originalText: String,
        extractive: String,
        keyword: String,
        structural: String
    ): String {
        // Choose based on content characteristics
        return when {
            structural != extractive && structural.length > 20 -> structural
            extractive.length in 50..300 -> extractive
            keyword.isNotEmpty() -> keyword
            else -> originalText.take(200) + if (originalText.length > 200) "..." else ""
        }
    }
    
    private fun extractKeywords(text: String): List<String> {
        val words = text.lowercase()
            .split(Regex("\\W+"))
            .filter { it.length > 3 }
            .filter { !isStopWord(it) }
        
        // Count word frequency
        val wordFreq = words.groupingBy { it }.eachCount()
        
        // Return top frequent words
        return wordFreq.entries
            .sortedByDescending { it.value }
            .take(10)
            .map { it.key }
    }
    
    private fun isStopWord(word: String): Boolean {
        val stopWords = setOf(
            "the", "and", "or", "but", "in", "on", "at", "to", "for", "of", "with", "by",
            "this", "that", "these", "those", "is", "are", "was", "were", "be", "been",
            "have", "has", "had", "do", "does", "did", "will", "would", "could", "should",
            "may", "might", "must", "can", "shall", "from", "up", "out", "down", "off",
            "over", "under", "again", "further", "then", "once", "here", "there", "when",
            "where", "why", "how", "all", "any", "both", "each", "few", "more", "most",
            "other", "some", "such", "only", "own", "same", "so", "than", "too", "very"
        )
        return word in stopWords
    }
    
    private fun isInvoiceOrReceipt(text: String): Boolean {
        val indicators = listOf("invoice", "receipt", "total", "amount", "tax", "subtotal", "due", "paid")
        return indicators.any { text.contains(it, ignoreCase = true) }
    }
    
    private fun isBusinessCard(text: String): Boolean {
        val indicators = listOf("phone", "email", "@", "company", "manager", "director", "ceo")
        return indicators.count { text.contains(it, ignoreCase = true) } >= 2
    }
    
    private fun isLetter(text: String): Boolean {
        val indicators = listOf("dear", "sincerely", "regards", "yours", "letter")
        return indicators.any { text.contains(it, ignoreCase = true) }
    }
    
    private fun isMenu(text: String): Boolean {
        val indicators = listOf("menu", "price", "$", "appetizer", "main", "dessert", "drink")
        return indicators.count { text.contains(it, ignoreCase = true) } >= 2
    }
    
    private fun isCertificate(text: String): Boolean {
        val indicators = listOf("certificate", "certify", "awarded", "completion", "achievement")
        return indicators.any { text.contains(it, ignoreCase = true) }
    }
    
    private fun summarizeInvoice(text: String): String {
        val lines = text.lines().filter { it.trim().isNotEmpty() }
        val summary = StringBuilder("Invoice/Receipt: ")
        
        // Extract key information
        lines.forEach { line ->
            when {
                line.contains("total", ignoreCase = true) && line.any { it.isDigit() } -> 
                    summary.append("Total: ${extractAmount(line)}. ")
                line.contains("date", ignoreCase = true) -> 
                    summary.append("Date: ${extractDate(line)}. ")
                line.contains("invoice", ignoreCase = true) && line.any { it.isDigit() } ->
                    summary.append("Invoice #${extractNumber(line)}. ")
            }
        }
        
        return summary.toString().trim()
    }
    
    private fun summarizeBusinessCard(text: String): String {
        val lines = text.lines().filter { it.trim().isNotEmpty() }
        val summary = StringBuilder("Business Card: ")
        
        lines.forEach { line ->
            when {
                line.contains("@") -> summary.append("Email: $line. ")
                line.matches(Regex(".*\\d{3}.*\\d{3}.*\\d{4}.*")) -> summary.append("Phone: $line. ")
                line.contains("company", ignoreCase = true) || 
                line.contains("inc", ignoreCase = true) || 
                line.contains("llc", ignoreCase = true) -> summary.append("Company: $line. ")
            }
        }
        
        return summary.toString().trim()
    }
    
    private fun summarizeLetter(text: String): String {
        val sentences = text.split(Regex("[.!?]+")).map { it.trim() }.filter { it.isNotEmpty() }
        return "Letter: " + sentences.take(2).joinToString(". ")
    }
    
    private fun summarizeMenu(text: String): String {
        val lines = text.lines().filter { it.trim().isNotEmpty() }
        val items = lines.filter { line ->
            line.any { it.isDigit() } && (line.contains("$") || line.matches(Regex(".*\\d+\\.\\d{2}.*")))
        }
        
        return "Menu with ${items.size} items: " + items.take(3).joinToString(", ")
    }
    
    private fun summarizeCertificate(text: String): String {
        val lines = text.lines().filter { it.trim().isNotEmpty() }
        return "Certificate: " + lines.take(3).joinToString(" ")
    }
    
    private fun extractAmount(text: String): String {
        val amountRegex = Regex("\\$?\\d+\\.\\d{2}")
        return amountRegex.find(text)?.value ?: "amount not found"
    }
    
    private fun extractDate(text: String): String {
        val dateRegex = Regex("\\d{1,2}[/-]\\d{1,2}[/-]\\d{2,4}")
        return dateRegex.find(text)?.value ?: "date not found"
    }
    
    private fun extractNumber(text: String): String {
        val numberRegex = Regex("\\d+")
        return numberRegex.find(text)?.value ?: "number not found"
    }
    
    companion object {
        private const val MAX_SUMMARY_LENGTH = 200
        private const val MIN_TEXT_LENGTH_FOR_SUMMARY = 50
        
        // Common stop words to filter out
        private val STOP_WORDS = setOf(
            "a", "an", "and", "are", "as", "at", "be", "by", "for", "from",
            "has", "he", "in", "is", "it", "its", "of", "on", "that", "the",
            "to", "was", "will", "with", "the", "this", "but", "they", "have",
            "had", "what", "said", "each", "which", "she", "do", "how", "their",
            "if", "up", "out", "many", "then", "them", "these", "so", "some",
            "her", "would", "make", "like", "into", "him", "time", "two", "more",
            "go", "no", "way", "could", "my", "than", "first", "been", "call",
            "who", "oil", "sit", "now", "find", "down", "day", "did", "get",
            "come", "made", "may", "part"
        )
    }
    
    fun summarizeText(text: String): String? {
        if (text.length < MIN_TEXT_LENGTH_FOR_SUMMARY) {
            return null
        }
        
        return try {
            when {
                text.length <= MAX_SUMMARY_LENGTH -> text.trim()
                else -> {
                    // Apply summarization algorithm
                    val summary = extractiveSummarization(text)
                    summary.ifEmpty { 
                        // Fallback to simple truncation
                        truncateSummary(text)
                    }
                }
            }
        } catch (e: Exception) {
            // Fallback to truncation if summarization fails
            truncateSummary(text)
        }
    }
    
    private fun extractiveSummarization(text: String): String {
        // Clean and normalize text first
        val cleanText = text.replace(Regex("[\\r\\n]+"), " ")
            .replace(Regex("\\s+"), " ")
            .trim()
        
        // Split text into sentences
        val sentences = splitIntoSentences(cleanText)
        if (sentences.isEmpty()) return ""
        
        // If only 1-2 sentences, return them
        if (sentences.size <= 2) {
            return sentences.joinToString(". ") + "."
        }
        
        // Extract key topics and themes
        val keyTopics = extractKeyTopics(cleanText)
        
        // Calculate enhanced sentence scores
        val sentenceScores = calculateEnhancedSentenceScores(sentences, cleanText, keyTopics)
        
        // Select top sentences for summary
        val topSentences = selectTopSentences(sentences, sentenceScores)
        
        // Create coherent summary
        val summary = createCoherentSummary(topSentences, keyTopics)
        
        return summary.take(MAX_SUMMARY_LENGTH).trim()
    }
    
    private fun extractKeyTopics(text: String): List<String> {
        val words = extractWords(text)
        val wordFreq = words.groupingBy { it }.eachCount()
        
        // Get most frequent meaningful words
        val keyWords = wordFreq.entries
            .filter { it.key.length > 3 }
            .sortedByDescending { it.value }
            .take(8)
            .map { it.key }
        
        // Look for named entities (capitalized words)
        val namedEntities = text.split(Regex("\\s+"))
            .filter { it.matches(Regex("[A-Z][a-z]+")) && it.length > 2 }
            .distinct()
            .take(5)
        
        return (keyWords + namedEntities).distinct()
    }
    
    private fun createCoherentSummary(sentences: List<String>, keyTopics: List<String>): String {
        if (sentences.isEmpty()) return ""
        
        // Ensure sentences flow logically
        val orderedSentences = sentences.sortedBy { sentence ->
            // Prefer sentences that introduce topics (contain multiple key topics)
            val topicCount = keyTopics.count { topic -> 
                sentence.lowercase().contains(topic.lowercase()) 
            }
            -topicCount // Negative for descending order
        }
        
        // Join with proper punctuation
        return orderedSentences.joinToString(". ") { sentence ->
            sentence.trim().let { s ->
                if (s.endsWith(".") || s.endsWith("!") || s.endsWith("?")) s else "$s"
            }
        } + if (!orderedSentences.last().trim().endsWith(".")) "." else ""
    }
    
    private fun splitIntoSentences(text: String): List<String> {
        return text.split(Regex("[.!?]+"))
            .map { it.trim() }
            .filter { it.isNotEmpty() && it.length > 10 }
    }
    
    private fun calculateEnhancedSentenceScores(sentences: List<String>, fullText: String, keyTopics: List<String>): Map<String, Double> {
        val wordFreq = calculateWordFrequency(fullText)
        val scores = mutableMapOf<String, Double>()
        
        for (sentence in sentences) {
            val words = extractWords(sentence)
            if (words.isEmpty()) continue
            
            var score = 0.0
            var wordCount = 0
            
            // Base score from word frequency
            for (word in words) {
                val freq = wordFreq[word] ?: 0
                score += freq
                wordCount++
            }
            
            // Average word frequency as base score
            var finalScore = if (wordCount > 0) score / wordCount else 0.0
            
            // Key topic bonus (major factor)
            val topicMatches = keyTopics.count { topic -> 
                sentence.lowercase().contains(topic.lowercase()) 
            }
            if (topicMatches > 0) {
                finalScore *= (1.0 + topicMatches * 0.5)
            }
            
            // Length bonus (prefer medium-length sentences)
            val lengthBonus = when {
                sentence.length < 30 -> 0.7
                sentence.length > 150 -> 0.8
                else -> 1.0
            }
            finalScore *= lengthBonus
            
            // Position bonus (first and last sentences often important)
            val position = sentences.indexOf(sentence)
            val positionBonus = when {
                position == 0 -> 1.3 // First sentence
                position == sentences.size - 1 -> 1.1 // Last sentence
                position < sentences.size * 0.2 -> 1.2 // Early sentences
                else -> 1.0
            }
            finalScore *= positionBonus
            
            // Numbers and dates bonus
            if (sentence.contains(Regex("\\d+"))) {
                finalScore *= 1.15
            }
            
            // Question or exclamation bonus (often important)
            if (sentence.contains(Regex("[?!]"))) {
                finalScore *= 1.1
            }
            
            // Proper nouns bonus (names, places)
            val properNouns = sentence.split(Regex("\\s+"))
                .count { it.matches(Regex("[A-Z][a-z]+")) }
            if (properNouns > 0) {
                finalScore *= (1.0 + properNouns * 0.1)
            }
            
            scores[sentence] = finalScore
        }
        
        return scores
    }
    
    private fun calculateWordFrequency(text: String): Map<String, Int> {
        val words = extractWords(text)
        val frequency = mutableMapOf<String, Int>()
        
        for (word in words) {
            frequency[word] = frequency.getOrDefault(word, 0) + 1
        }
        
        return frequency
    }
    
    private fun extractWords(text: String): List<String> {
        return text.lowercase()
            .split(Regex("[^a-zA-Z0-9]+"))
            .map { it.trim() }
            .filter { 
                it.isNotEmpty() && 
                it.length > 2 && 
                !STOP_WORDS.contains(it) &&
                !it.matches(Regex("\\d+")) // Filter out pure numbers
            }
    }
    
    private fun selectTopSentences(sentences: List<String>, scores: Map<String, Double>): List<String> {
        val sortedSentences = sentences.sortedByDescending { scores[it] ?: 0.0 }
        
        val selectedSentences = mutableListOf<String>()
        var totalLength = 0
        
        for (sentence in sortedSentences) {
            if (totalLength + sentence.length <= MAX_SUMMARY_LENGTH) {
                selectedSentences.add(sentence)
                totalLength += sentence.length
            } else {
                break
            }
        }
        
        // Maintain original order
        return selectedSentences.sortedBy { sentences.indexOf(it) }
    }
    
    private fun truncateSummary(text: String): String {
        val truncated = text.take(MAX_SUMMARY_LENGTH)
        
        // Try to end at a word boundary
        val lastSpaceIndex = truncated.lastIndexOf(' ')
        return if (lastSpaceIndex > MAX_SUMMARY_LENGTH * 0.8) {
            truncated.substring(0, lastSpaceIndex) + "..."
        } else {
            "$truncated..."
        }
    }
}