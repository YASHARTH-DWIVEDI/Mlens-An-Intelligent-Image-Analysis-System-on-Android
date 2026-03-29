package com.mlens.app.ml;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u0000 12\u00020\u0001:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0002J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\r\u001a\u00020\u0005H\u0002J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J$\u0010\u0013\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J0\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\u0016\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0010\u00100\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002\u00a8\u00062"}, d2 = {"Lcom/mlens/app/ml/TextSummarizer;", "", "()V", "calculateEnhancedSentenceScores", "", "", "", "sentences", "", "fullText", "keyTopics", "calculateWordFrequency", "", "text", "chooseBestSummary", "originalText", "extractive", "keyword", "structural", "createCoherentSummary", "extractAmount", "extractDate", "extractKeyTopics", "extractKeywords", "extractNumber", "extractWords", "extractiveSummarization", "extractiveSummarizationAdvanced", "isBusinessCard", "", "isCertificate", "isInvoiceOrReceipt", "isLetter", "isMenu", "isStopWord", "word", "keywordBasedSummary", "selectTopSentences", "scores", "splitIntoSentences", "structuralSummary", "summarizeBusinessCard", "summarizeCertificate", "summarizeInvoice", "summarizeLetter", "summarizeMenu", "summarizeText", "summarizeTextAdvanced", "truncateSummary", "Companion", "app_debug"})
public final class TextSummarizer {
    private static final int MAX_SUMMARY_LENGTH = 200;
    private static final int MIN_TEXT_LENGTH_FOR_SUMMARY = 50;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Set<java.lang.String> STOP_WORDS = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.mlens.app.ml.TextSummarizer.Companion Companion = null;
    
    public TextSummarizer() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String summarizeTextAdvanced(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return null;
    }
    
    private final java.lang.String extractiveSummarizationAdvanced(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String keywordBasedSummary(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String structuralSummary(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String chooseBestSummary(java.lang.String originalText, java.lang.String extractive, java.lang.String keyword, java.lang.String structural) {
        return null;
    }
    
    private final java.util.List<java.lang.String> extractKeywords(java.lang.String text) {
        return null;
    }
    
    private final boolean isStopWord(java.lang.String word) {
        return false;
    }
    
    private final boolean isInvoiceOrReceipt(java.lang.String text) {
        return false;
    }
    
    private final boolean isBusinessCard(java.lang.String text) {
        return false;
    }
    
    private final boolean isLetter(java.lang.String text) {
        return false;
    }
    
    private final boolean isMenu(java.lang.String text) {
        return false;
    }
    
    private final boolean isCertificate(java.lang.String text) {
        return false;
    }
    
    private final java.lang.String summarizeInvoice(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String summarizeBusinessCard(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String summarizeLetter(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String summarizeMenu(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String summarizeCertificate(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String extractAmount(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String extractDate(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String extractNumber(java.lang.String text) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String summarizeText(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return null;
    }
    
    private final java.lang.String extractiveSummarization(java.lang.String text) {
        return null;
    }
    
    private final java.util.List<java.lang.String> extractKeyTopics(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String createCoherentSummary(java.util.List<java.lang.String> sentences, java.util.List<java.lang.String> keyTopics) {
        return null;
    }
    
    private final java.util.List<java.lang.String> splitIntoSentences(java.lang.String text) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, java.lang.Double> calculateEnhancedSentenceScores(java.util.List<java.lang.String> sentences, java.lang.String fullText, java.util.List<java.lang.String> keyTopics) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, java.lang.Integer> calculateWordFrequency(java.lang.String text) {
        return null;
    }
    
    private final java.util.List<java.lang.String> extractWords(java.lang.String text) {
        return null;
    }
    
    private final java.util.List<java.lang.String> selectTopSentences(java.util.List<java.lang.String> sentences, java.util.Map<java.lang.String, java.lang.Double> scores) {
        return null;
    }
    
    private final java.lang.String truncateSummary(java.lang.String text) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/mlens/app/ml/TextSummarizer$Companion;", "", "()V", "MAX_SUMMARY_LENGTH", "", "MIN_TEXT_LENGTH_FOR_SUMMARY", "STOP_WORDS", "", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}