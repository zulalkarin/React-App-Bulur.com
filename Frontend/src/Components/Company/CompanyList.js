
import React from "react";
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import PhoneEnabledTwoToneIcon from '@mui/icons-material/PhoneEnabledTwoTone';
import { Link } from "react-router-dom";


const ExpandMore = styled((props) => {
   
    const { expand, ...other } = props;
    return <IconButton {...other} />;
    })
  
    (({ theme, expand }) => ({
    transform: !expand ? 'rotate(0deg)' : 'rotate(180deg)',
    marginLeft: 'auto',
    transition: theme.transitions.create('transform', {
      duration: theme.transitions.duration.shortest,
    }),
    }));

    const linkStyle2 = {
        textDecoration: "none",
        boxShadow:"none,",
        color: 'aliceblue',
        
      };
      

function CompanyList(props) {
    const { id, title, info, phoneNumber, adress, ilceName, ilName} = props;
    const [expanded, setExpanded] = React.useState(false);


    const handleExpandClick = () => {
      setExpanded(!expanded);
    };


    return (
        <div >
            <Card sx={{ width: 700 , margin:3, textAlign:"left", backgroundColor: "#dee0dc"}}>
                <CardHeader
                    avatar={
                        <Link to={{pathName: '/companies/' + id}} style={linkStyle2}>
                        <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
                           {title.charAt(0).toUpperCase()}
                        </Avatar>
                        </Link>
                    }
                    title={title}
                    subheader ={ ilName+ ", " +  ilceName}
                />  
                <CardContent>
                    <Typography variant="body2" color="text.secondary">
                        {info}  
                        <br></br>
                        
                        <br></br>
                        <h4>Adres:</h4> {adress}    
                    </Typography>
                </CardContent>
                <CardActions disableSpacing>
                    <ExpandMore 
                        expand={expanded}
                        onClick={handleExpandClick}
                        aria-expanded={expanded}
                        aria-label="show more"
                    >
                        <PhoneEnabledTwoToneIcon />
                    </ExpandMore>
                </CardActions>
                <Collapse in={expanded} timeout="auto" unmountOnExit >
                    <CardContent >
                        <h4 color="text.secondary">Telefon Numarası: </h4>{phoneNumber}
                    </CardContent>
                </Collapse>
            </Card>
        </div>
    )

}

export default CompanyList;

