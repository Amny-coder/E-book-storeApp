

CREATE TABLE IF NOT EXISTS Ebook(
    id identity,
    author_name VARCHAR(100) NOT NULL,
    title VARCHAR(250) NOT NULL,
    isbn VARCHAR(30) NOT NULL,
    doc_source VARCHAR(150),
    description TEXT NOT NULL,
    content BLOB NOT NULL,
    book_cover BLOB NOT NULL,
    book_size BIGINT NOT NULL,
    createdAt TIMESTAMP NOT NULL
);