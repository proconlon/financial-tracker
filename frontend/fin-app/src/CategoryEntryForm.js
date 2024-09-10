import React, { useState } from 'react';
import Input from '@mui/joy/Input';  // Use Input instead of TextField
import Button from '@mui/joy/Button';
import Typography from '@mui/joy/Typography';

const CategoryEntryForm = () => {
    const [merchantName, setMerchantName] = useState('');
    const [category, setCategory] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Merchant:', merchantName);
        console.log('Category:', category);

        // Reset the form after submission
        setMerchantName('');
        setCategory('');
    };

    return (
        <div style={{ padding: '20px', maxWidth: '400px', margin: 'auto' }}>
            <Typography level="h2" component="h2" sx={{ mb: 2 }}>
                Merchant Category Entry
            </Typography>

            <form onSubmit={handleSubmit}>
                {/* Merchant Name Input */}
                <Input
                    placeholder="Merchant Name"
                    value={merchantName}
                    onChange={(e) => setMerchantName(e.target.value)}
                    sx={{ mb: 2 }}
                    required
                />

                {/* Category Input */}
                <Input
                    placeholder="Category"
                    value={category}
                    onChange={(e) => setCategory(e.target.value)}
                    sx={{ mb: 2 }}
                    required
                />

                <Button type="submit" variant="solid">
                    Submit
                </Button>
            </form>
        </div>
    );
};

export default CategoryEntryForm;
