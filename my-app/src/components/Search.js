import React, { useState } from 'react';

function SearchBar() {
  const [query, setQuery] = useState('');
  const [firstVideoId, setFirstVideoId] = useState('');

  const handleSearch = async (event) => {
    event.preventDefault();
    if (query.trim() === '') return;

    try {
      const response = await fetch(`http://localhost:8080/search?query=${encodeURIComponent(query)}`);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      if (data.items && data.items.length > 0) {
        setFirstVideoId(data.items[0].id.videoId); // Get the first video's ID
      }
    } catch (error) {
      console.error('Error occurred while searching:', error);
    }
  };

  return (
    <div>
      <form onSubmit={handleSearch}>
        <input
          type="text"
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          placeholder="Search..."
        />
        <button type="submit">Search</button>
      </form>
      
      {firstVideoId && (
        <div>
          <h3>Playing First Video</h3>
          <iframe
            width="560"
            height="315"
            src={`https://www.youtube.com/embed/${firstVideoId}?autoplay=1`}
            frameBorder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowFullScreen
            title="YouTube Video"
            
          ></iframe>
        </div>
      )}
    </div>
  );
}

export default SearchBar;
