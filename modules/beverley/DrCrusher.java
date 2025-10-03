package com.vulpuslabs.beverley;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
//[/user-imports]


public class Beverley extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

@SuppressWarnings("this-escape") 
public Beverley( long moduleID, VoltageObjects voltageObjects )
{
   super( moduleID, voltageObjects, "Beverley", ModuleType.ModuleType_Effect, 1.4 );

   InitializeControls();


   canBeBypassed = false;
   SetSkin( "a727b935ad7c4402897f2b804f4a282c" );
}

void InitializeControls()
{

   rightIn = new VoltageAudioJack( "rightIn", "Right Input", this, JackType.JackType_AudioInput );
   AddComponent( rightIn );
   rightIn.SetWantsMouseNotifications( false );
   rightIn.SetPosition( 23, 50 );
   rightIn.SetSize( 25, 25 );
   rightIn.SetSkin( "Jack Round Mint Ring" );

   leftIn = new VoltageAudioJack( "leftIn", "Left Input", this, JackType.JackType_AudioInput );
   AddComponent( leftIn );
   leftIn.SetWantsMouseNotifications( false );
   leftIn.SetPosition( 23, 20 );
   leftIn.SetSize( 25, 25 );
   leftIn.SetSkin( "Jack Round Mint Ring" );

   leftOut = new VoltageAudioJack( "leftOut", "Left Output", this, JackType.JackType_AudioOutput );
   AddComponent( leftOut );
   leftOut.SetWantsMouseNotifications( false );
   leftOut.SetPosition( 54, 20 );
   leftOut.SetSize( 25, 25 );
   leftOut.SetSkin( "Jack Round Yellow Ring" );

   rightOut = new VoltageAudioJack( "rightOut", "Right Output", this, JackType.JackType_AudioOutput );
   AddComponent( rightOut );
   rightOut.SetWantsMouseNotifications( false );
   rightOut.SetPosition( 54, 50 );
   rightOut.SetSize( 25, 25 );
   rightOut.SetSkin( "Jack Round Yellow Ring" );

   bitDepthKnob = new VoltageKnob( "bitDepthKnob", "Bit Depth", this, 1, 16, 4 );
   AddComponent( bitDepthKnob );
   bitDepthKnob.SetWantsMouseNotifications( false );
   bitDepthKnob.SetPosition( 60, 164 );
   bitDepthKnob.SetSize( 32, 32 );
   bitDepthKnob.SetSkin( "Knurled Plastic Plum" );
   bitDepthKnob.SetRange( 1, 16, 4, false, 0 );
   bitDepthKnob.SetKnobParams( 215, 145 );
   bitDepthKnob.DisplayValueInPercent( false );
   bitDepthKnob.SetKnobAdjustsRing( true );
   bitDepthKnob.SetMidpointValue( 4 );

   gammaKnob = new VoltageKnob( "gammaKnob", "Gamma", this, -1, 1, 0 );
   AddComponent( gammaKnob );
   gammaKnob.SetWantsMouseNotifications( false );
   gammaKnob.SetPosition( 5, 133 );
   gammaKnob.SetSize( 32, 32 );
   gammaKnob.SetSkin( "Knurled Plastic Sky" );
   gammaKnob.SetRange( -1, 1, 0, false, 0 );
   gammaKnob.SetKnobParams( 215, 145 );
   gammaKnob.DisplayValueInPercent( false );
   gammaKnob.SetKnobAdjustsRing( true );

   bitDepthModIn = new VoltageAudioJack( "bitDepthModIn", "Bit Depth Mod", this, JackType.JackType_AudioInput );
   AddComponent( bitDepthModIn );
   bitDepthModIn.SetWantsMouseNotifications( false );
   bitDepthModIn.SetPosition( 15, 292 );
   bitDepthModIn.SetSize( 25, 25 );
   bitDepthModIn.SetSkin( "Jack Round Plum Ring" );

   gammaModIn = new VoltageAudioJack( "gammaModIn", "Gamma Mod", this, JackType.JackType_AudioInput );
   AddComponent( gammaModIn );
   gammaModIn.SetWantsMouseNotifications( false );
   gammaModIn.SetPosition( 60, 292 );
   gammaModIn.SetSize( 25, 25 );
   gammaModIn.SetSkin( "Jack Round Sky Ring" );

   textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "BEVERLEY" );
   AddComponent( textLabel1 );
   textLabel1.SetWantsMouseNotifications( false );
   textLabel1.SetPosition( 0, 0 );
   textLabel1.SetSize( 100, 15 );
   textLabel1.SetEditable( false, false );
   textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel1.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel1.SetBorderSize( 1 );
   textLabel1.SetMultiLineEdit( false );
   textLabel1.SetIsNumberEditor( false );
   textLabel1.SetNumberEditorRange( 0, 100 );
   textLabel1.SetNumberEditorInterval( 1 );
   textLabel1.SetNumberEditorUsesMouseWheel( false );
   textLabel1.SetHasCustomTextHoverColor( false );
   textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel1.SetFont( "Arial", 10, true, false );

   bitDepthModAmt = new VoltageKnob( "bitDepthModAmt", "Bit Depth Mod Amount", this, -1, 1.0, 0 );
   AddComponent( bitDepthModAmt );
   bitDepthModAmt.SetWantsMouseNotifications( false );
   bitDepthModAmt.SetPosition( 15, 260 );
   bitDepthModAmt.SetSize( 25, 25 );
   bitDepthModAmt.SetSkin( "ARP2500 Sm Violet" );
   bitDepthModAmt.SetRange( -1, 1.0, 0, false, 0 );
   bitDepthModAmt.SetKnobParams( 215, 145 );
   bitDepthModAmt.DisplayValueInPercent( false );
   bitDepthModAmt.SetKnobAdjustsRing( true );

   gammaModAmtKnob = new VoltageKnob( "gammaModAmtKnob", "Gamma Mod Amount", this, -1, 1, 0 );
   AddComponent( gammaModAmtKnob );
   gammaModAmtKnob.SetWantsMouseNotifications( false );
   gammaModAmtKnob.SetPosition( 60, 260 );
   gammaModAmtKnob.SetSize( 25, 25 );
   gammaModAmtKnob.SetSkin( "ARP2500 Sm Aqua" );
   gammaModAmtKnob.SetRange( -1, 1, 0, false, 0 );
   gammaModAmtKnob.SetKnobParams( 215, 145 );
   gammaModAmtKnob.DisplayValueInPercent( false );
   gammaModAmtKnob.SetKnobAdjustsRing( true );

   textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "VULPUS LABS" );
   AddComponent( textLabel2 );
   textLabel2.SetWantsMouseNotifications( false );
   textLabel2.SetPosition( 0, 345 );
   textLabel2.SetSize( 100, 15 );
   textLabel2.SetEditable( false, false );
   textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel2.SetBorderSize( 1 );
   textLabel2.SetMultiLineEdit( false );
   textLabel2.SetIsNumberEditor( false );
   textLabel2.SetNumberEditorRange( 0, 100 );
   textLabel2.SetNumberEditorInterval( 1 );
   textLabel2.SetNumberEditorUsesMouseWheel( false );
   textLabel2.SetHasCustomTextHoverColor( false );
   textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel2.SetFont( "Arial", 10, true, false );

   textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "IN" );
   AddComponent( textLabel3 );
   textLabel3.SetWantsMouseNotifications( false );
   textLabel3.SetPosition( 19, 78 );
   textLabel3.SetSize( 34, 15 );
   textLabel3.SetEditable( false, false );
   textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel3.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel3.SetBorderSize( 1 );
   textLabel3.SetMultiLineEdit( false );
   textLabel3.SetIsNumberEditor( false );
   textLabel3.SetNumberEditorRange( 0, 100 );
   textLabel3.SetNumberEditorInterval( 1 );
   textLabel3.SetNumberEditorUsesMouseWheel( false );
   textLabel3.SetHasCustomTextHoverColor( false );
   textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel3.SetFont( "Arial", 10, true, false );

   textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "OUT" );
   AddComponent( textLabel4 );
   textLabel4.SetWantsMouseNotifications( false );
   textLabel4.SetPosition( 51, 78 );
   textLabel4.SetSize( 34, 15 );
   textLabel4.SetEditable( false, false );
   textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel4.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel4.SetBorderSize( 1 );
   textLabel4.SetMultiLineEdit( false );
   textLabel4.SetIsNumberEditor( false );
   textLabel4.SetNumberEditorRange( 0, 100 );
   textLabel4.SetNumberEditorInterval( 1 );
   textLabel4.SetNumberEditorUsesMouseWheel( false );
   textLabel4.SetHasCustomTextHoverColor( false );
   textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel4.SetFont( "Arial", 10, true, false );

   textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "L" );
   AddComponent( textLabel5 );
   textLabel5.SetWantsMouseNotifications( false );
   textLabel5.SetPosition( 0, 24 );
   textLabel5.SetSize( 20, 15 );
   textLabel5.SetEditable( false, false );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel5.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel5.SetBorderSize( 1 );
   textLabel5.SetMultiLineEdit( false );
   textLabel5.SetIsNumberEditor( false );
   textLabel5.SetNumberEditorRange( 0, 100 );
   textLabel5.SetNumberEditorInterval( 1 );
   textLabel5.SetNumberEditorUsesMouseWheel( false );
   textLabel5.SetHasCustomTextHoverColor( false );
   textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel5.SetFont( "Arial", 10, true, false );

   textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "L" );
   AddComponent( textLabel6 );
   textLabel6.SetWantsMouseNotifications( false );
   textLabel6.SetPosition( 80, 24 );
   textLabel6.SetSize( 20, 15 );
   textLabel6.SetEditable( false, false );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel6.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel6.SetBorderSize( 1 );
   textLabel6.SetMultiLineEdit( false );
   textLabel6.SetIsNumberEditor( false );
   textLabel6.SetNumberEditorRange( 0, 100 );
   textLabel6.SetNumberEditorInterval( 1 );
   textLabel6.SetNumberEditorUsesMouseWheel( false );
   textLabel6.SetHasCustomTextHoverColor( false );
   textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel6.SetFont( "Arial", 10, true, false );

   textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "R" );
   AddComponent( textLabel7 );
   textLabel7.SetWantsMouseNotifications( false );
   textLabel7.SetPosition( 0, 55 );
   textLabel7.SetSize( 20, 15 );
   textLabel7.SetEditable( false, false );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel7.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel7.SetBorderSize( 1 );
   textLabel7.SetMultiLineEdit( false );
   textLabel7.SetIsNumberEditor( false );
   textLabel7.SetNumberEditorRange( 0, 100 );
   textLabel7.SetNumberEditorInterval( 1 );
   textLabel7.SetNumberEditorUsesMouseWheel( false );
   textLabel7.SetHasCustomTextHoverColor( false );
   textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel7.SetFont( "Arial", 10, true, false );

   textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "R" );
   AddComponent( textLabel8 );
   textLabel8.SetWantsMouseNotifications( false );
   textLabel8.SetPosition( 80, 55 );
   textLabel8.SetSize( 20, 15 );
   textLabel8.SetEditable( false, false );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel8.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel8.SetBorderSize( 1 );
   textLabel8.SetMultiLineEdit( false );
   textLabel8.SetIsNumberEditor( false );
   textLabel8.SetNumberEditorRange( 0, 100 );
   textLabel8.SetNumberEditorInterval( 1 );
   textLabel8.SetNumberEditorUsesMouseWheel( false );
   textLabel8.SetHasCustomTextHoverColor( false );
   textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel8.SetFont( "Arial", 10, true, false );

   textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "DEPTH" );
   AddComponent( textLabel9 );
   textLabel9.SetWantsMouseNotifications( false );
   textLabel9.SetPosition( 10, 322 );
   textLabel9.SetSize( 34, 15 );
   textLabel9.SetEditable( false, false );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel9.SetColor( new Color( 208, 96, 208, 255 ) );
   textLabel9.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel9.SetBorderSize( 1 );
   textLabel9.SetMultiLineEdit( false );
   textLabel9.SetIsNumberEditor( false );
   textLabel9.SetNumberEditorRange( 0, 100 );
   textLabel9.SetNumberEditorInterval( 1 );
   textLabel9.SetNumberEditorUsesMouseWheel( false );
   textLabel9.SetHasCustomTextHoverColor( false );
   textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel9.SetFont( "Arial", 10, true, false );

   textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "GAMMA" );
   AddComponent( textLabel10 );
   textLabel10.SetWantsMouseNotifications( false );
   textLabel10.SetPosition( 55, 322 );
   textLabel10.SetSize( 34, 15 );
   textLabel10.SetEditable( false, false );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel10.SetColor( new Color( 0, 176, 255, 255 ) );
   textLabel10.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel10.SetBorderSize( 1 );
   textLabel10.SetMultiLineEdit( false );
   textLabel10.SetIsNumberEditor( false );
   textLabel10.SetNumberEditorRange( 0, 100 );
   textLabel10.SetNumberEditorInterval( 1 );
   textLabel10.SetNumberEditorUsesMouseWheel( false );
   textLabel10.SetHasCustomTextHoverColor( false );
   textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel10.SetFont( "Arial", 10, true, false );

   textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "BIT DEPTH" );
   AddComponent( textLabel11 );
   textLabel11.SetWantsMouseNotifications( false );
   textLabel11.SetPosition( 7, 170 );
   textLabel11.SetSize( 52, 15 );
   textLabel11.SetEditable( false, false );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel11.SetColor( new Color( 208, 96, 208, 255 ) );
   textLabel11.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel11.SetBorderSize( 1 );
   textLabel11.SetMultiLineEdit( false );
   textLabel11.SetIsNumberEditor( false );
   textLabel11.SetNumberEditorRange( 0, 100 );
   textLabel11.SetNumberEditorInterval( 1 );
   textLabel11.SetNumberEditorUsesMouseWheel( false );
   textLabel11.SetHasCustomTextHoverColor( false );
   textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel11.SetFont( "Arial", 10, true, false );

   textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "GAMMA" );
   AddComponent( textLabel12 );
   textLabel12.SetWantsMouseNotifications( false );
   textLabel12.SetPosition( 40, 141 );
   textLabel12.SetSize( 40, 15 );
   textLabel12.SetEditable( false, false );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel12.SetColor( new Color( 0, 176, 255, 255 ) );
   textLabel12.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel12.SetBorderSize( 1 );
   textLabel12.SetMultiLineEdit( false );
   textLabel12.SetIsNumberEditor( false );
   textLabel12.SetNumberEditorRange( 0, 100 );
   textLabel12.SetNumberEditorInterval( 1 );
   textLabel12.SetNumberEditorUsesMouseWheel( false );
   textLabel12.SetHasCustomTextHoverColor( false );
   textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel12.SetFont( "Arial", 10, true, false );

   textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "SMOOTHING" );
   AddComponent( textLabel13 );
   textLabel13.SetWantsMouseNotifications( false );
   textLabel13.SetPosition( 39, 203 );
   textLabel13.SetSize( 58, 15 );
   textLabel13.SetEditable( false, false );
   textLabel13.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel13.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel13.SetColor( new Color( 96, 128, 112, 255 ) );
   textLabel13.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel13.SetBorderSize( 1 );
   textLabel13.SetMultiLineEdit( false );
   textLabel13.SetIsNumberEditor( false );
   textLabel13.SetNumberEditorRange( 0, 100 );
   textLabel13.SetNumberEditorInterval( 1 );
   textLabel13.SetNumberEditorUsesMouseWheel( false );
   textLabel13.SetHasCustomTextHoverColor( false );
   textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel13.SetFont( "Arial", 10, true, false );

   textLabel17 = new VoltageLabel( "textLabel17", "textLabel17", this, "CRUSH MODE" );
   AddComponent( textLabel17 );
   textLabel17.SetWantsMouseNotifications( false );
   textLabel17.SetPosition( 4, 236 );
   textLabel17.SetSize( 65, 15 );
   textLabel17.SetEditable( false, false );
   textLabel17.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel17.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel17.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel17.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel17.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel17.SetBorderSize( 1 );
   textLabel17.SetMultiLineEdit( false );
   textLabel17.SetIsNumberEditor( false );
   textLabel17.SetNumberEditorRange( 0, 100 );
   textLabel17.SetNumberEditorInterval( 1 );
   textLabel17.SetNumberEditorUsesMouseWheel( false );
   textLabel17.SetHasCustomTextHoverColor( false );
   textLabel17.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel17.SetFont( "Arial", 10, true, true );

   smoothingKnob = new VoltageKnob( "smoothingKnob", "Smoothing", this, 0.0, 1, 0 );
   AddComponent( smoothingKnob );
   smoothingKnob.SetWantsMouseNotifications( false );
   smoothingKnob.SetPosition( 4, 194 );
   smoothingKnob.SetSize( 32, 32 );
   smoothingKnob.SetSkin( "Knurled Plastic Mint" );
   smoothingKnob.SetRange( 0.0, 1, 0, false, 0 );
   smoothingKnob.SetKnobParams( 215, 145 );
   smoothingKnob.DisplayValueInPercent( false );
   smoothingKnob.SetKnobAdjustsRing( true );
   smoothingKnob.SetMidpointValue( 0.2 );

   crushModeSwitch = new VoltageSwitch( "crushModeSwitch", "Crush Mode", this, 0 );
   AddComponent( crushModeSwitch );
   crushModeSwitch.SetWantsMouseNotifications( false );
   crushModeSwitch.SetPosition( 72, 238 );
   crushModeSwitch.SetSize( 21, 12 );
   crushModeSwitch.SetSkin( "2-State Slide Horizontal" );

   gainKnob = new VoltageKnob( "gainKnob", "Gain", this, 0, 20, 0 );
   AddComponent( gainKnob );
   gainKnob.SetWantsMouseNotifications( false );
   gainKnob.SetPosition( 60, 102 );
   gainKnob.SetSize( 32, 32 );
   gainKnob.SetSkin( "Knurled Plastic Yellow" );
   gainKnob.SetRange( 0, 20, 0, false, 0 );
   gainKnob.SetKnobParams( 215, 145 );
   gainKnob.SetUnits( "dB" );
   gainKnob.DisplayValueInPercent( false );
   gainKnob.SetKnobAdjustsRing( true );

   textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "GAIN" );
   AddComponent( textLabel15 );
   textLabel15.SetWantsMouseNotifications( false );
   textLabel15.SetPosition( 16, 110 );
   textLabel15.SetSize( 40, 15 );
   textLabel15.SetEditable( false, false );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.Right );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel15.SetColor( new Color( 255, 255, 15, 255 ) );
   textLabel15.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel15.SetBorderSize( 1 );
   textLabel15.SetMultiLineEdit( false );
   textLabel15.SetIsNumberEditor( false );
   textLabel15.SetNumberEditorRange( 0, 100 );
   textLabel15.SetNumberEditorInterval( 1 );
   textLabel15.SetNumberEditorUsesMouseWheel( false );
   textLabel15.SetHasCustomTextHoverColor( false );
   textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel15.SetFont( "Arial", 10, true, false );

   autoGainToggle = new VoltageToggle( "autoGainToggle", "Auto Gain Toggle", this, false, 0 );
   AddComponent( autoGainToggle );
   autoGainToggle.SetWantsMouseNotifications( false );
   autoGainToggle.SetPosition( 10, 94 );
   autoGainToggle.SetSize( 15, 15 );
   autoGainToggle.SetSkin( "Small Square Red" );
   autoGainToggle.ShowOverlay( false );
   autoGainToggle.SetOverlayText( "" );

   textLabel16 = new VoltageLabel( "textLabel16", "textLabel16", this, "(AUTO)" );
   AddComponent( textLabel16 );
   textLabel16.SetWantsMouseNotifications( false );
   textLabel16.SetPosition( 2, 110 );
   textLabel16.SetSize( 30, 15 );
   textLabel16.SetEditable( false, false );
   textLabel16.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel16.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel16.SetColor( new Color( 255, 255, 15, 255 ) );
   textLabel16.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel16.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel16.SetBorderSize( 1 );
   textLabel16.SetMultiLineEdit( false );
   textLabel16.SetIsNumberEditor( false );
   textLabel16.SetNumberEditorRange( 0, 100 );
   textLabel16.SetNumberEditorInterval( 1 );
   textLabel16.SetNumberEditorUsesMouseWheel( false );
   textLabel16.SetHasCustomTextHoverColor( false );
   textLabel16.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel16.SetFont( "Arial", 10, true, false );
}



//-------------------------------------------------------------------------------
//  public void Initialize()

//  Initialize will get called shortly after your module's constructor runs. You can use it to
//  do any initialization that the auto-generated code doesn't handle.
//-------------------------------------------------------------------------------
@Override
public void Initialize()
{
   //[user-Initialize]   Add your own initialization code here



   //[/user-Initialize]
}


//-------------------------------------------------------------------------------
//  public void Destroy()

//  Destroy will get called just before your module gets deleted. You can use it to perform any
//  cleanup that's not handled automatically by Java.
//-------------------------------------------------------------------------------
@Override
public void Destroy()
{
   super.Destroy();
   //[user-Destroy]   Add your own module-getting-deleted code here



   //[/user-Destroy]
}


//-------------------------------------------------------------------------------
//  public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )

//  Notify will get called when various events occur - control values changing, timers firing, etc.
//-------------------------------------------------------------------------------
@Override
public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )
{
   //[user-Notify]   Add your own notification handling code between this line and the notify-close comment
   switch( notification )
   {
      case Knob_Changed:   // doubleValue is the new VoltageKnob value
      {
         if (component == bitDepthKnob) {
            baseBitDepth = doubleValue;
            recalculateBitDepth(0.0);
         }
         if (component == gammaKnob) {
            baseGamma = doubleValue;
            recalculateGamma(0.0);
         }
         if (component == smoothingKnob) {
            recalculateSmoothing(doubleValue);
         }
         if (component == bitDepthModAmt) depthModAmount = doubleValue * 3.0;
         if (component == gammaModAmtKnob) gammaModAmount = doubleValue * 0.2;
         if (component == gainKnob) {
            setGainDb(doubleValue);
         }
      }
      break;
   
      case Slider_Changed:   // doubleValue is the new slider value
      {
      }
      break;
   
      case Button_Changed:   // doubleValue is the new button/toggle button value
      {
         setAutoGain(doubleValue == 1.0);
      }
      break;
   
      case Switch_Changed:   // doubleValue is the new switch value
      {
         if (component == crushModeSwitch) {
            setCrushMode(doubleValue == 1.0);
         }
      }
      break;
   
      case Jack_Connected:   // longValue is the new cable ID
      {
         if (component == rightIn) rightInIsConnected = true;
         if (component == bitDepthModIn) depthIsConnected = true;
         if (component == gammaModIn) gammaIsConnected = true;
      }
      break;
   
      case Jack_Disconnected:   // All cables have been disconnected from this jack
      {
         if (component == rightIn) rightInIsConnected = false;
         if (component == bitDepthModIn) {
            depthIsConnected = false;
            recalculateBitDepth(0.0);
         }
         if (component == gammaModIn) {
            gammaIsConnected = false;
            recalculateGamma(0.0);
         }
      }
      break;
   
      case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
      {
      }
      break;
   
      case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_RightButtonDown:   // called when user releases right mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_RightButtonUp:   // called when user right-clicks on an object that receives mouse notifications
      {
      }
      break;
   
      case Object_LeftButtonDoubleClick: // called when user left-button double-clicks on an object that receives mouse notifications
      {
      }
      break;
   
      // Less common notifications:
   
      case Named_Timer:   // object contains a String with the name of the timer that has fired
      {
      }
      break;
   
      case Canvas_Painting:   // About to paint canvas.  object is a java.awt.Rectangle with painting boundaries
      {
      }
      break;
   
      case Canvas_Painted:   // Canvas painting is complete
      {
      }
      break;
   
      case Control_DragStart:    // A user has started dragging on a control that has been marked as draggable
      {
      }
      break;
   
      case Control_DragOn:       // This control has been dragged over during a drag operation. object contains the dragged object
      {
      }
      break;
   
      case Control_DragOff:      // This control has been dragged over during a drag operation. object contains the dragged object
      {
      }
      break;
   
      case Control_DragEnd:      // A user has ended their drag on a control that has been marked as draggable
      {
      }
      break;
   
      case Label_Changed:        // The text of an editable text control has changed
      {
      }
      break;
   
      case SoundPlayback_Start:   // A sound has begun playback
      {
      }
      break;
   
      case SoundPlayback_End:     // A sound has ended playback
      {
      }
      break;
   
      case Scrollbar_Position:    // longValue is the new scrollbar position
      {
      }
      break;
   
      case PolyVoices_Changed:    // longValue is the new number of poly voices
      {
      }
      break;
   
      case File_Dropped:     // 'object' is a String containing the file path
      {
      }
      break;
   
      case Preset_Loading_Start:   // called when preset loading begins
      {
      }
      break;
   
      case Preset_Loading_Finish:  // called when preset loading finishes
      {
      }
      break;
   
      case Variation_Loading_Start:    // sent when a variation is about to load
      {
      }
      break;
   
      case Variation_Loading_Finish:   // sent when a variation has just finished loading
      {
      }
      break;
   
      case Tempo_Changed:     // doubleValue is the new tempo
      {
      }
      break;
   
      case Randomized:     // called when the module's controls get randomized
      {
      }
      break;
   
      case VariationListChanged:   // sent when a variation gets added, deleted, or renamed, or the variations list gets reordered
      {
      }
      break;
   
      case Key_Press:     // sent when module has keyboard focus and a key is pressed; object is a VoltageKeyPressInfo object
      {
      }
      break;
   
      case Reset:    // sent when the module has been reset to default settings
      {
      }
      break;
   
      case Keyboard_NoteOn:   // sent when a note has been pressed on a VoltageKeyboard object. longValue is the note value ( 0-127 )
      {
      }
      break;
   
      case Keyboard_NoteOff:   // sent when a note has been released on a VoltageKeyboard object. longValue is the note value ( 0-127 )
      {
      }
      break;
   
      case Curve_Changed:   // sent when user has edited a curve's value. 'object' will be a VoltageCurve.CurveChangeNotification object.
      {
      }
      break;
   }



   return false;
   //[/user-Notify]
}


//-------------------------------------------------------------------------------
//  public void ProcessSample()

//  ProcessSample is called once per sample. Usually it's where you read
//  from input jacks, process audio, and write it to your output jacks.
//  Since ProcesssSample gets called 48,000 times per second, offload CPU-intensive operations
//  to other threads when possible and avoid calling native functions.
//-------------------------------------------------------------------------------
@Override
public void ProcessSample()
{
   //[user-ProcessSample]   Add your own process-sampling code here
   if (gammaIsConnected) recalculateGamma(gammaModIn.GetValue());
   if (depthIsConnected) recalculateBitDepth(bitDepthModIn.GetValue());
   
   double leftOutput = processSampleLeft(leftIn.GetValue());
   double rightOutput = rightInIsConnected
      ? processSampleRight(rightIn.GetValue())
      : leftOutput;
      
   leftOut.SetValue(leftOutput);
   rightOut.SetValue(rightOutput);
   //[/user-ProcessSample]
}


//-------------------------------------------------------------------------------
//  public String GetTooltipText( VoltageComponent component )

//  Gets called when a tooltip is about to display for a control. Override it if
//  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
//  for instance, you can translate the knob's current value to a log-based string and display it here.
//-------------------------------------------------------------------------------
@Override
public String GetTooltipText( VoltageComponent component )
{
   //[user-GetTooltipText]   Add your own code here
      if (component == crushModeSwitch) {
      return crushModeSwitch.GetValue() == 0.0
         ? "Asymmetric"
         : "Symmetric";
   }


   return super.GetTooltipText( component );
   //[/user-GetTooltipText]
}


//-------------------------------------------------------------------------------
//  public void EditComponentValue( VoltageComponent component, double newValue, String newText )

//  Gets called after a user clicks on a tooltip and types in a new value for a control. Override this if
//  you've changed the default tooltip display (translating a linear value to logarithmic, for instance)
//  in GetTooltipText().
//-------------------------------------------------------------------------------
@Override
public void EditComponentValue( VoltageComponent component, double newValue, String newText )
{
   //[user-EditComponentValue]   Add your own code here



   //[/user-EditComponentValue]
   super.EditComponentValue( component, newValue, newText );
}


//-------------------------------------------------------------------------------
//  public void OnUndoRedo( String undoType, double newValue, Object optionalObject )

//  If you've created custom undo events via calls to CreateUndoEvent, you'll need to
//  process them in this function when they get triggered by undo/redo actions.
//-------------------------------------------------------------------------------
@Override
public void OnUndoRedo( String undoType, double newValue, Object optionalObject )
{
   //[user-OnUndoRedo]   Add your own code here



   //[/user-OnUndoRedo]
}


//-------------------------------------------------------------------------------
//  public byte[] GetStateInformation()

//  Gets called when the module's state gets saved, typically when the user saves a preset with
//  this module in it. Voltage Modular will automatically save the states of knobs, sliders, etc.,
//  but if you have any custom state information you need to save, return it from this function.
//-------------------------------------------------------------------------------
@Override
public byte[] GetStateInformation()
{
   //[user-GetStateInformation]   Add your own code here



   return null;
   //[/user-GetStateInformation]
}


//-------------------------------------------------------------------------------
//  public void SetStateInformation(byte[] stateInfo)

//  Gets called when this module's state is getting restored, typically when a user opens a preset with
//  this module in it. The stateInfo parameter will contain whatever custom data you stored in GetStateInformation().
//-------------------------------------------------------------------------------
@Override
public void SetStateInformation(byte[] stateInfo)
{
   //[user-SetStateInformation]   Add your own code here



   //[/user-SetStateInformation]
}


//-------------------------------------------------------------------------------
//  public byte[] GetStateInformationForVariations()

//  Gets called when a user saves a variation with this module in it.
//  Voltage Modular will automatically save the states of knobs, sliders, etc.,
//  but if you have any custom state information you need to save, return it from this function.
//-------------------------------------------------------------------------------
@Override
public byte[] GetStateInformationForVariations()
{
   //[user-GetStateInformationForVariations]   Add your own code here



   return GetStateInformation();
   //[/user-GetStateInformationForVariations]
}


//-------------------------------------------------------------------------------
//  public void SetStateInformationForVariations(byte[] stateInfo)

//  Gets called when a user loads a variation with this module in it.
//  The stateInfo parameter will contain whatever custom data you stored in GetStateInformationForVariations().
//-------------------------------------------------------------------------------
@Override
public void SetStateInformationForVariations(byte[] stateInfo)
{
   //[user-SetStateInformationForVariations]   Add your own code here
   SetStateInformation(stateInfo);



   //[/user-SetStateInformationForVariations]
}


// Auto-generated variables
private VoltageLabel textLabel16;
private VoltageToggle autoGainToggle;
private VoltageLabel textLabel15;
private VoltageKnob gainKnob;
private VoltageSwitch crushModeSwitch;
private VoltageKnob smoothingKnob;
private VoltageLabel textLabel17;
private VoltageLabel textLabel13;
private VoltageLabel textLabel12;
private VoltageLabel textLabel11;
private VoltageLabel textLabel10;
private VoltageLabel textLabel9;
private VoltageLabel textLabel8;
private VoltageLabel textLabel7;
private VoltageLabel textLabel6;
private VoltageLabel textLabel5;
private VoltageLabel textLabel4;
private VoltageLabel textLabel3;
private VoltageLabel textLabel2;
private VoltageKnob gammaModAmtKnob;
private VoltageKnob bitDepthModAmt;
private VoltageLabel textLabel1;
private VoltageAudioJack gammaModIn;
private VoltageAudioJack bitDepthModIn;
private VoltageKnob gammaKnob;
private VoltageKnob bitDepthKnob;
private VoltageAudioJack rightOut;
private VoltageAudioJack leftOut;
private VoltageAudioJack leftIn;
private VoltageAudioJack rightIn;


//[user-code-and-variables]    Add your own variables and functions here
private double baseGamma;
private double baseBitDepth;
private double depthModAmount;
private double gammaModAmount;

private boolean rightInIsConnected;
private boolean depthIsConnected;
private boolean gammaIsConnected;

private static class InterpolatedBitCrusher {

   private static final double THRESHOLD = 0.05;
   private static final double THRESHOLD_RECIPROCAL = 1.0 / THRESHOLD;
   
   private final BitCrusher low = new BitCrusher();
   private final BitCrusher high = new BitCrusher();
   private double fraction;
   private double smoothing;
   private double gamma;
   private double gammaReciprocal;
   private double gain;
   private double gainReciprocal;
   private boolean autoGain;
   private boolean symmetricCrush;
   private final ExponentialPeak peak = new ExponentialPeak(48000);
   
   public void setDepth(double bitDepth) {
      int bitFloor = (int) Math.floor(bitDepth);
      int bitCeil = (int) Math.ceil(bitDepth);
      this.fraction = bitDepth - bitFloor;
        
      low.setLevels((1 << bitFloor) - 1);
      high.setLevels((1 << bitCeil) - 1);
   }
   
   public void setAutoGain(boolean autoGain) {
      this.autoGain = autoGain;
   }
   
   public void setGainDb(double gainDb) {
      this.gain = Math.pow(10.0, gainDb * 0.05);
      this.gainReciprocal = 1.0 / this.gain;
   }
   
   public void setGamma(double gamma) {
      this.gamma = gamma;
      this.gammaReciprocal = 1.0 / gamma;
   }
   
   public void setSmoothing(double smoothing) {
      double steepness = 1.0 - smoothing;
      low.setSteepness(steepness);
      high.setSteepness(steepness);
   }
   
   public void setCrushMode(boolean crushMode) {
      this.symmetricCrush = crushMode;
   }
   
   public double apply(double input) {
      // Power-law forward transform
      double absInput = Math.abs(input);
      double signInput = Math.signum(input);
         
      double gain = autoGain
         ? peak.gainCompensation(absInput)
         : this.gain;
      double gainReciprocal = autoGain
         ? 1.0 / gain
         : this.gainReciprocal;
         
      double clamped = Math.min(1.0, gain * absInput);
      double gammaTransformed = Math.pow(clamped, gammaReciprocal);
      
      double quantized = symmetricCrush
         ? symmetricQuantize(gammaTransformed)
         : asymmetricQuantize(signInput, gammaTransformed);
         
      // Power-law inverse transform
      return signInput * gainReciprocal * Math.pow(quantized, gamma);
   }
   
   private double asymmetricQuantize(double signInput, double gammaTransformed) {
      double crushInput = ((gammaTransformed * signInput) + 1.0) * 0.5;

      double quantized = symmetricQuantize(crushInput);
      
      if (gammaTransformed < THRESHOLD) {
        double frac = gammaTransformed * THRESHOLD_RECIPROCAL;
        quantized = quantized * frac + (crushInput * (1.0 - frac));
      }
      
      return signInput * ((quantized * 2.0) - 1.0);
   }
   
   private double symmetricQuantize(double gammaTransformed) {
      // Interpolate between the two crushed versions
      double crushedHigh = high.crush(gammaTransformed);
      double crushedLow = low.crush(gammaTransformed);
      double quantized = crushedLow + fraction * (crushedHigh - crushedLow);
        
      return quantized;
   }


}

private static class BitCrusher {
   private int levels;
   private double step;
   private double stepReciprocal;
   private double steepness;
   private double power;
   
   public void setLevels(int levels) {
      this.levels = levels;
      this.step = 1.0 / levels;
      this.stepReciprocal = levels;
   }
   
   public void setSteepness(double steepness) {
      this.steepness = steepness;
      this.power = 1.0 / (1.0 - steepness + 0.01);
   }
   
   double crush(double input) {
      double scaled = input * stepReciprocal;
      
      int low = (int) Math.floor(scaled);
      int high = (int) Math.ceil(scaled);
      
      double quantizedLow = low * step;
      if (low == high) return quantizedLow;
      
      double intervalFraction = (input - quantizedLow) * stepReciprocal;
      double smoothedFraction = sigmoidish(intervalFraction);
      
      return quantizedLow + (smoothedFraction * step);
   }
   
   private double linear(double x) {
      double quantised = x >= 0.5 ? 1.0 : 0.0;
      return (quantised * steepness) + (x * (1.0 - steepness));
   }
   
   private double sigmoidish(double x) {
      if (steepness == 0) return x;

      double smooth = x * x * (3.0 - 2.0 * x);
    
      if (steepness < 0.5) {
         double blend = steepness * 2.0;
         return (1.0 - blend) * x + blend * smooth;
      }
   
      double step = x >= 0.5 ? 1.0 : 0.0;
      double blend = (steepness - 0.5) * 2.0;
      return (1.0 - blend) * smooth + blend * step;
   }
}

private static final class ExponentialPeak {
   private static final double GATE_THRESHOLD = 0.005; // 0.01v threshold
   private static final double TARGET_LEVEL = 1.0; // 5v target
   private static final double GATE_THRESHOLD_RECIPROCAL = TARGET_LEVEL / GATE_THRESHOLD;
   
   private final double attackCoeff;
   private final double inverseAttackCoeff;
   private final double releaseCoeff;
   private final double inverseReleaseCoeff;
   private double peakLevel;
   
   public ExponentialPeak(int sampleRate) {
      this.attackCoeff = timeConstantToCoeff(0.5, sampleRate);
      this.inverseAttackCoeff = 1.0 - attackCoeff;
      this.releaseCoeff = timeConstantToCoeff(50.0, sampleRate);
      this.inverseReleaseCoeff = 1.0 - releaseCoeff;
   }
   
   private static double timeConstantToCoeff(double timeConstantMs, double sampleRate) {
      double timeConstantSamples = (timeConstantMs / 1000.0) * sampleRate;
      return Math.exp(-1.0 / timeConstantSamples);
   }
   
   public double gainCompensation(double absInput) {
      peakLevel = absInput > peakLevel
         ? attackCoeff * peakLevel + inverseAttackCoeff * absInput
         : releaseCoeff * peakLevel;
      
      if (peakLevel < GATE_THRESHOLD) return GATE_THRESHOLD_RECIPROCAL;
      
      return TARGET_LEVEL / peakLevel;
   }
}
      
private final InterpolatedBitCrusher crusherLeft = new InterpolatedBitCrusher();
private final InterpolatedBitCrusher crusherRight = new InterpolatedBitCrusher();

private void recalculateGamma(double gammaMod) {
   double gamma = Math.pow(10.0, clamp(-1.0, 1.0, baseGamma + (gammaMod * gammaModAmount)));
   crusherLeft.setGamma(gamma);
   crusherRight.setGamma(gamma);
}

private void recalculateBitDepth(double bitDepthMod) {
   double bitDepth = clamp(1.0, 16.0, baseBitDepth + (bitDepthMod * depthModAmount));
   crusherLeft.setDepth(bitDepth);
   crusherRight.setDepth(bitDepth);
}

private void recalculateSmoothing(double smoothing) {
   crusherLeft.setSmoothing(smoothing);
   crusherRight.setSmoothing(smoothing);
}

private void setGainDb(double gainDb) {
   crusherLeft.setGainDb(gainDb);
   crusherRight.setGainDb(gainDb);
}

private void setAutoGain(boolean autoGain) {
   crusherLeft.setAutoGain(autoGain);
   crusherRight.setAutoGain(autoGain);
}

private void setCrushMode(boolean isSymmetric) {
   crusherLeft.setCrushMode(isSymmetric);
   crusherRight.setCrushMode(isSymmetric);
}

private double clamp(double value, double max, double min) {
   return Math.max(min, Math.min(max, value));
}

private double processSampleLeft(double sample) {
   return crusherLeft.apply(sample * 0.2) * 5.0;
}

private double processSampleRight(double sample) {
   return crusherRight.apply(sample * 0.2) * 5.0;
}

//[/user-code-and-variables]
}

 