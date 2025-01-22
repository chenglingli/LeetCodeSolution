Table: user_content

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| content_id  | int     |
| content_text| varchar |
+-------------+---------+
content_id is the unique key for this table.
Each row contains a unique ID and the corresponding text content.
Write a solution to transform the text in the content_text column by applying the following rules:

Convert the first letter of each word to uppercase and the remaining letters to lowercase
Special handling for words containing special characters:
For words connected with a hyphen -, both parts should be capitalized (e.g., top-rated → Top-Rated)
All other formatting and spacing should remain unchanged
Return the result table that includes both the original content_text and the modified text following the above rules.

The result format is in the following example.



Example:

Input:

user_content table:

+------------+---------------------------------+
| content_id | content_text                    |
+------------+---------------------------------+
| 1          | hello world of SQL              |
| 2          | the QUICK-brown fox             |
| 3          | modern-day DATA science         |
| 4          | web-based FRONT-end development |
+------------+---------------------------------+
Output:

+------------+---------------------------------+---------------------------------+
| content_id | original_text                   | converted_text                  |
+------------+---------------------------------+---------------------------------+
| 1          | hello world of SQL              | Hello World Of Sql              |
| 2          | the QUICK-brown fox             | The Quick-Brown Fox             |
| 3          | modern-day DATA science         | Modern-Day Data Science         |
| 4          | web-based FRONT-end development | Web-Based Front-End Development |
+------------+---------------------------------+---------------------------------+
Explanation:

For content_id = 1:
Each word's first letter is capitalized: "Hello World Of Sql"
For content_id = 2:
Contains the hyphenated word "QUICK-brown" which becomes "Quick-Brown"
Other words follow normal capitalization rules
For content_id = 3:
Hyphenated word "modern-day" becomes "Modern-Day"
"DATA" is converted to "Data"
For content_id = 4:
Contains two hyphenated words: "web-based" → "Web-Based"
And "FRONT-end" → "Front-End"


-- 替换 -x  为 -X，替换" x" 为 " X"
SELECT content_id, content_text AS original_text,
REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(
    CONCAT(UPPER(SUBSTRING(content_text, 1, 1)), LOWER(SUBSTRING(content_text, 2, LENGTH(content_text) - 1))),
    " z", " Z"), " y", " Y"), " x", " X"), " w", " W"), " v", " V"), " u", " U"), " t", " T"), " s", " S"), " r", " R"), " q", " Q"), " p", " P"), " o", " O"), " n", " N"), " m", " M"), " l", " L"), " k", " K"), " j", " J"), " i", " I"), " h", " H"), " g", " G"), " f", " F"), " e", " E"), " d", " D"), " c", " C"), " b", " B"), " a", " A") ,"-z", "-Z"),"-y", "-Y"),"-x", "-X"),"-w", "-W"),"-v", "-V"),"-u", "-U"),"-t", "-T"),"-s", "-S"),"-r", "-R"),"-q", "-Q"),"-p", "-P"),"-o", "-O"),"-n", "-N"),"-m", "-M"),"-l", "-L"),"-k", "-K"),"-j", "-J"),"-i", "-I"),"-h", "-H"),"-g", "-G"),"-f", "-F"),"-e", "-E"),"-d", "-D"),"-c", "-C"),"-b", "-B"),"-a", "-A") AS converted_text FROM user_content


-- 逐字符地处理user_content表中的文本，
-- 根据前一个字符来智能地决定每个字符的大小写。
-- 它首先将文本分割成单个字符，然后检查每个字符的前一个字符来决定当前字符应该大写还是小写。最后，它将处理后的字符重新组合成转换后的文本。
with recursive iter (pos) as (
    select 1 as pos
    union all
    select i.pos + 1
    from iter i
    where i.pos + 1 <= (select max(length(content_text)) from user_content)
),

t as (
    select content_id, content_text, iter.pos,
           substring(content_text, iter.pos, 1) as token,
           lag(substring(content_text, iter.pos, 1)) over (partition by content_id order by iter.pos) as prev_token
    from user_content
         cross join iter
   where substring(content_text, iter.pos, 1) is not null
)

select content_id, content_text as original_text,
       group_concat(case when prev_token is null or prev_token in (' ', '-') then upper(token)
                         else lower(token)
                    end order by pos separator ''
                   ) as converted_text
  from t
group by content_id, content_text




WITH RECURSIVE cte AS (
    SELECT content_id, content_text, REGEXP_SUBSTR(content_text, '[\\s-]*\\b\\w+\\b[\\s-]*') as word, REGEXP_REPLACE(content_text, '^[\\s-]*\\b\\w+\\b[\\s-]*', '') as remain, 1 as rank_id
    FROM user_content
    UNION ALL
    SELECT content_id, content_text, REGEXP_SUBSTR(remain, '[\\s-]*\\b\\w+\\b[\\s-]*') AS word, REGEXP_REPLACE(remain, '^[\\s-]*\\b\\w+\\b[\\s-]*', '') AS remain, rank_id + 1 AS rank_id
    FROM cte
    WHERE remain REGEXP '\\b\\w+\\b'
)

SELECT content_id, content_text AS original_text, GROUP_CONCAT(CONCAT(LOWER(SUBSTRING(word, 1, REGEXP_INSTR(word, '[A-Za-z]') - 1)), UPPER(SUBSTRING(word, REGEXP_INSTR(word, '[A-Za-z]'), 1)), LOWER(SUBSTRING(word, REGEXP_INSTR(word, '[A-Za-z]') + 1))) ORDER BY rank_id SEPARATOR '') AS converted_text
FROM cte
GROUP BY content_id



