import React from 'react'
import { useParams } from 'react-router-dom'

export default function CompanyPage() {
    const {id} = useParams();
  return (
   
    <div>
        
        Company!! {id} 
    
    </div>
  )
}


