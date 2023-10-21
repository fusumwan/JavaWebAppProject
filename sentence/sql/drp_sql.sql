SELECT CONCAT('<option value=\"', event, '\">', event, '</option>') AS option_text
FROM sentence.subject_sentence
GROUP BY event;