class 361 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect52
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.at_shock_blast_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect53
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_shock_blast_ra'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect54
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_shock_blast_ta'
		bOnMultiTarget=True
	End Object
	Desc="쇼크 블라스트" //Shock Blast
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect52',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect53',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect54',SpecificStage=0)
}