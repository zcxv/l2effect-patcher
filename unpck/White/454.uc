class 454 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect22
		AttachOn=AM_LA
		EffectClass=Class'LineageEffect.s_u807_fighter_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect23
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.s_u807_ta'
	End Object
	Desc="디펜시브스탠스" //Defensive Stance
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect22',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect23',SpecificStage=0)
}