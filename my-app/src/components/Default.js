import React, { useEffect, useState } from 'react';

function OpeningPage({ endpoint }) {
    console.log(endpoint);
    
  const [responseText, setResponseText] = useState('');

  useEffect(() => {
    fetch(`http://localhost:8080/openingparent/${endpoint}`)
      .then(response => response.text())
      .then(data => {
        setResponseText(data);
      })
      .catch(error => {
        console.error(`Error fetching the ${endpoint || 'default'} page:`, error);
      });
  }, [endpoint]);

  return (
    <div>
      <h1>{endpoint ? 'Open Page' : 'Default Open Page'}</h1>
      <p>{responseText}</p>
    </div>
  );
}

export default OpeningPage;
